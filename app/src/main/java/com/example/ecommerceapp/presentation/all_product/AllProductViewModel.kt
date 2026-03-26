package com.example.ecommerceapp.presentation.all_product

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
import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.domain.usecase.cart_remote_usecase.CartRemoteUseCase
import com.example.ecommerceapp.domain.usecase.product_remote_usecase.ProductRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class AllProductViewModel @Inject constructor(
    private val productRemoteUseCase : ProductRemoteUseCase,
    private val cartRemoteUseCase: CartRemoteUseCase,
    private val sharedPreferences: SharedPreferences,
) : ViewModel() {
    // create local state for all product
    private var _allProductState by mutableStateOf<AllProductState>(AllProductState.LoadingState)

    // exposed local state
    val allProductState : State<AllProductState> get() = derivedStateOf { _allProductState }

    // create local state for add cart product
    private var _addCartProductState by mutableStateOf<CartProductState>(CartProductState.IdleState)

    // exposes state for add cart product
    val addCartProductState : State<CartProductState> get() = derivedStateOf { _addCartProductState }

    // create refresh state
    var refreshState by mutableStateOf(false)

    init {
        viewModelScope.launch {
            // add delay for better transition
            delay(500)

            try{
                // get all product
                val getAllProduct : List<ProductModel> = productRemoteUseCase.getOnSaleProductUseCase(
                    userId = sharedPreferences.getString(Constants.USER_ID, "") ?: ""
                )

                // update state into data state
                _allProductState = AllProductState.DataState(
                    data = getAllProduct,
                )
            } catch (e : Exception) {
                // create error message
                val errMsg : String = "Error Happen : ${e.message}, ${e.stackTrace}"

                // update state into error state
                _allProductState = AllProductState.ErrorState(
                    errMsg = errMsg,
                )
            }
        }
    }

    fun onRefresh() {
        // update state into loading state
        _allProductState = AllProductState.LoadingState
        refreshState = true

        viewModelScope.launch {
            // add delay for better transition
            delay(500)

            try{
                // get all product
                val getAllProduct : List<ProductModel> = productRemoteUseCase.getOnSaleProductUseCase(
                    userId = sharedPreferences.getString(Constants.USER_ID, "") ?: ""
                )

                // update state into data state
                _allProductState = AllProductState.DataState(
                    data = getAllProduct,
                )

                refreshState = false
            } catch (e : Exception) {
                // create error message
                val errMsg : String = "Error Happen : ${e.message}, ${e.stackTrace}"

                // update state into error state
                _allProductState = AllProductState.ErrorState(
                    errMsg = errMsg,
                )

                refreshState = false
            }
        }
    }

    // create on event function
    fun onEvent(event : AllProductEvent) {
        when(event) {
            is AllProductEvent.AddCartEvent -> {
                // update state into loading state
                _addCartProductState = CartProductState.LoadingState

                viewModelScope.launch {
                    // add some delay for better transition
                    delay(600)

                    try{
                        // get data from state
                        val getCartDetail = event.cartDetailRequestModel

                        // update user requester
                        getCartDetail.userRequesterId = sharedPreferences.getString(Constants.USER_ID, "") ?: ""

                        // insert cart detail
                        val cartResponse = cartRemoteUseCase.addCartDetailUseCase(
                            cartDetailRequestModel = getCartDetail
                        )

                        // update state into data state
                        _addCartProductState = CartProductState.DataState(
                            data = cartResponse
                        )
                    } catch (e : Exception) {
                        // create err message
                        val errMsg : String = "Error Happen : ${e.message}, ${e.stackTrace}"

                        // update state into error state
                        _addCartProductState = CartProductState.ErrorState(
                            errMsg = errMsg
                        )
                    }
                }
            }
        }
    }

    // create function to update add cart state
    fun updateAddCartState(state : CartProductState) {
        _addCartProductState = state
    }
}