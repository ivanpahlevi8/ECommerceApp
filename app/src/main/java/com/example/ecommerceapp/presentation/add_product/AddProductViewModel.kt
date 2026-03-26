package com.example.ecommerceapp.presentation.add_product

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
class AddProductViewModel @Inject constructor(
    private val productRemoteUseCase: ProductRemoteUseCase,
    private val categoryRemoteUseCase: CategoryRemoteUseCase,
    private val sharedPreferences: SharedPreferences,
) : ViewModel() {
    // create local state for add product
    private var _addProductState by mutableStateOf<AddProductState>(AddProductState.IdleState)

    // exposed local state
    val addProductState : State<AddProductState> get() = derivedStateOf { _addProductState }

    // create local state for init data
    private var _initDataState by mutableStateOf<InitAddProductState>(InitAddProductState.LoadingState)

    // exposed local state
    val initDataState : State<InitAddProductState> get() = derivedStateOf { _initDataState }

    init {
        viewModelScope.launch {
            // add some delay for better transition
            delay(500)

            try{
                // get all category
                val getAllCategory : List<CategoryModel> = categoryRemoteUseCase.getAllCategoryUseCase()

                // update state into data state
                _initDataState = InitAddProductState.DataState(getAllCategory)
            } catch (e : Exception) {
                // create error message
                val errMsg : String = "Error happen : ${e.message}, ${e.stackTrace}"

                // update state into error state
                _initDataState = InitAddProductState.ErrorState(
                    errMsg = errMsg
                )
            }
        }
    }

    // create on event function
    fun onEvent(event : AddProductEvent) {
        when(event) {
            is AddProductEvent.AddProduct -> {
                // update state into loading state
                _addProductState = AddProductState.LoadingState

                // get product
                val getProduct = event.productInsert

                // assign user id on product
                getProduct.userId = sharedPreferences.getString(Constants.USER_ID, "") ?: ""
                Log.d("CHECK", "check on user id : ${getProduct.userId}")

                viewModelScope.launch {
                    try{
                        // add product
                        val returnProduct : ProductModel = productRemoteUseCase.insertProductUseCase(
                            getProduct
                        )

                        // update state into data state
                        _addProductState = AddProductState.DataState(
                            data = returnProduct
                        )
                    } catch (e : Exception) {
                        // create error message
                        val errMsg : String = "Error happen : ${e.message}, ${e.stackTrace}"

                        // update state into error state
                        _addProductState = AddProductState.ErrorState(
                            errMsg = errMsg
                        )
                    }
                }
            }
        }
    }

    // create function to update add product state
    fun updateAddProductState(state : AddProductState) {
        _addProductState = state
    }
}