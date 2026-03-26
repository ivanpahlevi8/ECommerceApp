package com.example.ecommerceapp.presentation.own_products_update

import android.content.SharedPreferences
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapp.core.value.Constants
import com.example.ecommerceapp.domain.models.CategoryModel
import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.domain.usecase.category_remote_usecase.CategoryRemoteUseCase
import com.example.ecommerceapp.domain.usecase.product_remote_usecase.ProductRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class OwnProductsUpdateViewModel @Inject constructor(
    private val productRemoteUseCase: ProductRemoteUseCase,
    private val categoryRemoteUseCase: CategoryRemoteUseCase,
    savedStateHandle: SavedStateHandle,
    private val sharedPreferences: SharedPreferences,
) : ViewModel() {
    // create init data state
    private var _initOwnProductsUpdateState by mutableStateOf<OwnProductsUpdateState>(OwnProductsUpdateState.LoadingState)

    // exposed data state
    val initOwnProductsUpdateState : State<OwnProductsUpdateState> get() = derivedStateOf { _initOwnProductsUpdateState }

    // create update product state
    private var _updateProductState by mutableStateOf<OwnProductsUpdateState>(OwnProductsUpdateState.IdleState)

    // exposed update product state
    val updateProductState : State<OwnProductsUpdateState> get() = derivedStateOf { _updateProductState }

    init {
        viewModelScope.launch {
            // add delay for better transition
            delay(500)

            try{
                // get product id
                val getProductId = savedStateHandle["productId"] ?: ""

                // get product by id
                val getProduct : ProductModel = productRemoteUseCase.getProductByIdUseCase(
                    productId = getProductId,
                )

                // get category list
                val getCategoryList : List<CategoryModel> = categoryRemoteUseCase.getAllCategoryUseCase()

                // update state into data state
                _initOwnProductsUpdateState = OwnProductsUpdateState.DataState(
                    data = getProduct,
                    categoryList = getCategoryList
                )
            } catch (e : Exception) {
                // create error message
                val errMsg : String = "Error happen : ${e.message}, ${e.stackTrace}"

                // update state into error state
                _initOwnProductsUpdateState = OwnProductsUpdateState.ErrorState(
                    errMsg = errMsg
                )
            }
        }
    }

    // create on event function
    fun onEvent(event : OwnProductsUpdateEvent) {
        when(event) {
            is OwnProductsUpdateEvent.OnUpdate -> {
                // update state on update product state
                _updateProductState = OwnProductsUpdateState.LoadingState

                viewModelScope.launch {
                    // add some delay for better transition
                    delay(500)

                    // get updated data
                    val updatedData = event.updateProduct

                    // update product user id
                    updatedData.userId = sharedPreferences.getString(Constants.USER_ID, "") ?: ""

                    try{
                        // update product
                        val getProduct = productRemoteUseCase.updateProductUseCase(
                            updatedData
                        )

                        // update state into data state
                        _updateProductState = OwnProductsUpdateState.DataState(
                            data = getProduct,
                            categoryList = listOf()
                        )
                    } catch (e : Exception) {
                        // create error message
                        val errMsg : String = "Error Happen : ${e.message}, ${e.stackTrace}"

                        // update state into error state
                        _updateProductState = OwnProductsUpdateState.ErrorState(
                            errMsg = errMsg,
                        )
                    }
                }
            }
        }
    }

    // create change update product state function
    fun changeUpdateProductState(state : OwnProductsUpdateState) {
        _updateProductState = state
    }
}