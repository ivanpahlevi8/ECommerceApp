package com.example.ecommerceapp.presentation.order

import android.content.SharedPreferences
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapp.core.value.Constants
import com.example.ecommerceapp.domain.models.order_models.OrderModel
import com.example.ecommerceapp.domain.usecase.order_remote_usecase.OrderRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val orderRemoteUseCase: OrderRemoteUseCase,
    private val sharedPreferences: SharedPreferences,
) : ViewModel() {
    // create order local state
    private var _orderLocalState by mutableStateOf<OrderState>(OrderState.LoadingState)

    // exposed order local state
    val orderLocalState : State<OrderState> get() = derivedStateOf { _orderLocalState }

    // create state for request order
    private var _requestOrderLocalState by mutableStateOf<OrderState>(OrderState.LoadingState)

    // exposed request order
    val requestOrderLocalState : State<OrderState> get() = derivedStateOf { _requestOrderLocalState }

    // create order event state
    private var _orderEventState by mutableStateOf<OrderEventState>(OrderEventState.IdleState)

    // exposed order event state
    val orderEventState : State<OrderEventState> get() = derivedStateOf { _orderEventState }

    // create state for refresh
    var orderRefresh by mutableStateOf(false)
    var orderRequestRefresh by mutableStateOf(false)

    init {
        viewModelScope.launch {
            // add some delay for better transition
            delay(600)

            try{
                // get order by user id
                val getOrder : List<OrderModel> = orderRemoteUseCase.getOrderUseCase(
                    userId = sharedPreferences.getString(Constants.USER_ID, "") ?: ""
                )

                // get request order by user id
                val getRequestOrder : List<OrderModel> = orderRemoteUseCase.getRequestedOrderUseCase(
                    ownerUserId = sharedPreferences.getString(Constants.USER_ID, "") ?: ""
                )

                // update state into order id
                _orderLocalState = OrderState.DataState(
                    data = getOrder
                )

                // update request order state
                _requestOrderLocalState = OrderState.DataState(
                    data = getRequestOrder
                )
            } catch (e : Exception) {
                // create error message
                val errMsg = "Error happen ; ${e.message}, ${e.stackTrace}"

                // update state into error state
                _orderLocalState = OrderState.ErrorState(
                    errMsg = errMsg,
                )

                // update request state into error state
                _requestOrderLocalState = OrderState.ErrorState(
                    errMsg = errMsg,
                )
            }
        }
    }

    // create on event function
    fun onEvent(event : OrderEvent) {
        when(event) {
            is OrderEvent.OnCancel -> {
                // get order id
                val getOrderId : Int = event.orderId

                // update state into loading state
                _orderEventState = OrderEventState.LoadingState

                viewModelScope.launch {
                    // add delay for better transition
                    delay(600)

                    try{
                        // get data
                        val getDataOrder : String = orderRemoteUseCase.updateOrderUseCase(
                            orderStatus = "CANCELED",
                            orderId = getOrderId
                        )

                        // update state into data state
                        _orderEventState = OrderEventState.DataState(
                            data = getDataOrder
                        )
                    } catch (e : Exception) {
                        // create error message
                        val errMsg = "Error happen ; ${e.message}, ${e.stackTrace}"

                        // update state into error state
                        _orderEventState = OrderEventState.ErrorState(
                            errMsg = errMsg
                        )
                    }
                }
            }
            is OrderEvent.OnApprove -> {
                // get order id
                val getOrderId : Int = event.orderId

                // update state into loading state
                _orderEventState = OrderEventState.LoadingState

                viewModelScope.launch {
                    // add delay for better transition
                    delay(600)

                    try{
                        // get data
                        val getDataOrder : String = orderRemoteUseCase.updateOrderUseCase(
                            orderStatus = "APPROVED",
                            orderId = getOrderId
                        )

                        // update state into data state
                        _orderEventState = OrderEventState.DataState(
                            data = getDataOrder
                        )
                    } catch (e : Exception) {
                        // create error message
                        val errMsg = "Error happen ; ${e.message}, ${e.stackTrace}"

                        // update state into error state
                        _orderEventState = OrderEventState.ErrorState(
                            errMsg = errMsg
                        )
                    }
                }
            }
        }
    }

    // create function on refresh order
    fun onRefreshOrder(){
        // update order state into loading
        _orderLocalState = OrderState.LoadingState

        // update refresh state
        orderRefresh = true

        viewModelScope.launch {
            // add some delay
            delay(600)

            try{
                // get order by user id
                val getOrder : List<OrderModel> = orderRemoteUseCase.getOrderUseCase(
                    userId = sharedPreferences.getString(Constants.USER_ID, "") ?: ""
                )

                // update state into order id
                _orderLocalState = OrderState.DataState(
                    data = getOrder
                )
            } catch (e : Exception) {
                // create error message
                val errMsg = "Error happen ; ${e.message}, ${e.stackTrace}"

                // update state into error state
                _orderLocalState = OrderState.ErrorState(
                    errMsg = errMsg,
                )
            }

            orderRefresh = false
        }
    }

    // create function on refresh request order
    fun onRefreshRequestOrder(){
        // update order state into loading
        _requestOrderLocalState = OrderState.LoadingState

        orderRequestRefresh = true;

        viewModelScope.launch {
            // add some delay
            delay(600)

            try{
                // get request order by user id
                val getRequestOrder : List<OrderModel> = orderRemoteUseCase.getRequestedOrderUseCase(
                    ownerUserId = sharedPreferences.getString(Constants.USER_ID, "") ?: ""
                )

                // update request order state
                _requestOrderLocalState = OrderState.DataState(
                    data = getRequestOrder
                )
            } catch (e : Exception) {
                // create error message
                val errMsg = "Error happen ; ${e.message}, ${e.stackTrace}"

                // update state into error state
                _requestOrderLocalState = OrderState.ErrorState(
                    errMsg = errMsg,
                )
            }

            orderRequestRefresh = false;
        }
    }
}