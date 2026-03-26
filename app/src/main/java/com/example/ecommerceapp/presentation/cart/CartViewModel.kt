package com.example.ecommerceapp.presentation.cart

import android.content.SharedPreferences
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapp.core.value.Constants
import com.example.ecommerceapp.domain.models.cart_models.CartModel
import com.example.ecommerceapp.domain.usecase.cart_remote_usecase.CartRemoteUseCase
import com.example.ecommerceapp.domain.usecase.order_remote_usecase.OrderRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartRemoteUseCase: CartRemoteUseCase,
    private val orderRemoteUseCase: OrderRemoteUseCase,
    private val sharedPreferences: SharedPreferences
) : ViewModel() {
    // create local state
    private var _cartState by mutableStateOf<CartState>(CartState.LoadingState)

    // exposed local state
    val cartState : State<CartState> get() = derivedStateOf { _cartState }

    // create is refresh state
    var isRefresh by mutableStateOf(false)

    // create local state for event
    private var _cartEventState by mutableStateOf<CartState>(CartState.IdleState)

    // exposed local state for event
    val cartEventState : State<CartState> get() = derivedStateOf { _cartEventState }

    init {
        // get user id
        val getUserId : String = sharedPreferences.getString(Constants.USER_ID, "") ?: ""

        viewModelScope.launch {
            // add delay
            delay(600)

            try{
                // get data
                val getData : CartModel? = cartRemoteUseCase.getCartUseCase(
                    userId = getUserId
                )

                // update state into data state
                _cartState = CartState.DataState(
                    data = getData
                )
            } catch (e : Exception) {
                // create error message
                val errMsg : String = "Error happen : ${e.message}, ${e.stackTrace}"

                // update state into error state
                _cartState = CartState.ErrorState(
                    errMsg = errMsg,
                )
            }
        }
    }

    // create on refresh function
    fun onRefresh() {
        // update state into loading state
        _cartState = CartState.LoadingState

        // update refresh state into true
        isRefresh = true

        // get user id
        val getUserId : String = sharedPreferences.getString(Constants.USER_ID, "") ?: ""

        viewModelScope.launch {
            // add delay for better transition
            delay(600)

            try{
                // get data
                val getData : CartModel? = cartRemoteUseCase.getCartUseCase(
                    userId = getUserId
                )

                // update state into data state
                _cartState = CartState.DataState(
                    data = getData
                )

                // update is refresh
                isRefresh = false
            } catch (e : Exception) {
                // create error message
                val errMsg : String = "Error happen : ${e.message}, ${e.stackTrace}"

                // update state into error state
                _cartState = CartState.ErrorState(
                    errMsg = errMsg,
                )

                // update is refresh
                isRefresh = false
            }
        }
    }

    // create on event function
    fun onEvent(event : CartEvent) {
        when(event) {
            is CartEvent.OnDeleteCartDetail -> {
                // update state into loading state
                _cartEventState = CartState.LoadingState

                // get cart detail id
                val getCartDetailId = event.cartDetailId

                viewModelScope.launch {
                    // add some delay for better transition
                    delay(600)

                    try{
                        // delete cart detail
                        val message = cartRemoteUseCase.deleteCartDetailUseCase(
                            cartDetailId = getCartDetailId
                        )

                        // update state into data state
                        _cartEventState = CartState.DataState(
                            data = message
                        )
                    } catch (e : Exception) {
                        // create error message
                        val errMsg : String = "Error happen : ${e.message}, ${e.stackTrace}"

                        // update state into error state
                        _cartEventState = CartState.ErrorState(
                            errMsg = errMsg
                        )
                    }
                }
            }
            is CartEvent.OnClearCartDetail -> {
                // update state into loading state
                 _cartEventState = CartState.LoadingState

                // get cart header id
                val getCartHeaderId = event.cartHeaderId

                viewModelScope.launch {
                    // add some delay
                    delay(600)

                    try{
                        // delete cart detail
                        val message = cartRemoteUseCase.clearCartDetailUseCase(
                            cartHeaderId = getCartHeaderId
                        )

                        // update state into data state
                        _cartEventState = CartState.DataState(
                            data = message
                        )
                    } catch (e : Exception) {
                        // create error message
                        val errMsg : String = "Error happen : ${e.message}, ${e.stackTrace}"

                        // update state into error state
                        _cartEventState = CartState.ErrorState(
                            errMsg = errMsg
                        )
                    }
                }
            }
            is CartEvent.OnDeleteCartHeader -> {
                // update state into loading state
                _cartEventState = CartState.LoadingState

                // get cart header id
                val getCartHeaderId = event.cartHeaderId

                viewModelScope.launch {
                    // add some delay
                    delay(600)

                    try{
                        // delete cart detail
                        val message = cartRemoteUseCase.deleteCartHeaderUseCase(
                            cartHeaderId = getCartHeaderId
                        )

                        // update state into data state
                        _cartEventState = CartState.DataState(
                            data = message
                        )
                    } catch (e : Exception) {
                        // create error message
                        val errMsg : String = "Error happen : ${e.message}, ${e.stackTrace}"

                        // update state into error state
                        _cartEventState = CartState.ErrorState(
                            errMsg = errMsg
                        )
                    }
                }
            }
            is CartEvent.OnOrderCart -> {
                // update state into loading state
                _cartEventState = CartState.LoadingState

                // get order request
                val orderRequest = event.orderCreateRequestModel

                viewModelScope.launch {
                    // add delay for better transition
                    delay(600)

                    try{
                        // create order
                        val response = orderRemoteUseCase.createOrderUseCase(
                            orderRequest = orderRequest
                        )

                        // update state into data state
                        _cartEventState = CartState.DataState(
                            response
                        )
                    } catch (e : Exception) {
                        // create error message
                        val errMsg : String = "Error happen : ${e.message}, ${e.stackTrace}"

                        // update state into error state
                        _cartEventState = CartState.ErrorState(
                            errMsg = errMsg
                        )
                    }
                }
            }
        }
    }

    // create function to update cart event state
    fun updateCartEventState(state : CartState) {
        _cartEventState = state
    }
}