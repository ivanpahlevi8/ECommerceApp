package com.example.ecommerceapp.presentation.own_products

import android.content.SharedPreferences
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapp.core.value.Constants
import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.domain.usecase.product_remote_usecase.ProductRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class OwnProductsViewModel @Inject constructor(
    private val productRemoteUseCase: ProductRemoteUseCase,
    private val sharedPreferences: SharedPreferences,
) : ViewModel() {
    // create local state for own products
    private var _ownProductsState by mutableStateOf<OwnProductsState>(OwnProductsState.LoadingState)

    // exposed local state
    val ownProductsState : State<OwnProductsState> get() = derivedStateOf { _ownProductsState }

    // create local state for delete own products
    private var _deleteOwnProductsState by mutableStateOf<OwnProductsEventState>(OwnProductsEventState.IdleState)

    // exposed local state for delete own products
    val deleteOwnProductsState : State<OwnProductsEventState> get() = derivedStateOf { _deleteOwnProductsState }

    // create refresh state
    var refreshState by mutableStateOf(false)

    init {
        viewModelScope.launch {
            // add some delay for better transition
            delay(600)

            try{
                // get data
                val getData : List<ProductModel> = productRemoteUseCase.getOwnProductsUseCase(
                    userId = sharedPreferences.getString(Constants.USER_ID, "") ?: ""
                )

                // update state into data state
                _ownProductsState = OwnProductsState.DataState(
                    data = getData,
                )
            } catch (e : Exception) {
                // create error message
                val errMsg : String = "Error happen : ${e.message}, ${e.stackTrace}"

                // update state into error state
                _ownProductsState = OwnProductsState.ErrorState(
                    errMsg = errMsg,
                )
            }
        }
    }

    // create on event function
    fun onEvent(event : OwnProductsEvent) {
        when(event) {
            is OwnProductsEvent.OnDelete -> {
                // get deleted product
                val deletedProduct = event.data

                // update delete state into loading state
                _deleteOwnProductsState = OwnProductsEventState.LoadingState

                viewModelScope.launch {
                    // add some delay for better transition
                    delay(600)

                    try{
                        // delete item
                        val productModel : ProductModel = productRemoteUseCase.deleteOwnProductUseCase(
                            productId = deletedProduct.productId
                        )

                        // update state into data state
                        _deleteOwnProductsState = OwnProductsEventState.DataState(
                            data = productModel
                        )

                        reInitData()
                    } catch (e : Exception) {
                        // create error message
                        val errMsg : String = "Error Happen : ${e.message}, ${e.stackTrace}"

                        // update state into error state
                        _deleteOwnProductsState = OwnProductsEventState.ErrorState(
                            errMsg = errMsg
                        )
                    }
                }
            }
        }
    }

    // create function to update state
    fun updateDeleteProductState(state : OwnProductsEventState) {
        _deleteOwnProductsState = state
    }

    private fun reInitData() {
        viewModelScope.launch {
            // update state
            _ownProductsState = OwnProductsState.LoadingState

            // add some delay for better transition
            delay(600)

            try{
                // get data
                val getData : List<ProductModel> = productRemoteUseCase.getOwnProductsUseCase(
                    userId = sharedPreferences.getString(Constants.USER_ID, "") ?: ""
                )

                // update state into data state
                _ownProductsState = OwnProductsState.DataState(
                    data = getData,
                )
            } catch (e : Exception) {
                // create error message
                val errMsg : String = "Error happen : ${e.message}, ${e.stackTrace}"

                // update state into error state
                _ownProductsState = OwnProductsState.ErrorState(
                    errMsg = errMsg,
                )
            }
        }
    }

    fun onRefresh() {
        refreshState = true

        reInitData()

        refreshState = false
    }
}