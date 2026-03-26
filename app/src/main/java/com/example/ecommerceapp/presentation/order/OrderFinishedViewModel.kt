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
class OrderFinishedViewModel @Inject constructor(
    private val orderRemoteUseCase: OrderRemoteUseCase,
    private val sharedPreferences: SharedPreferences,
) : ViewModel() {
    // create order local state
    private var _orderFinishedLocalState by mutableStateOf<OrderState>(OrderState.LoadingState)

    // exposed order local state
    val orderFinishedLocalState : State<OrderState> get() = derivedStateOf { _orderFinishedLocalState }

    // create state for request order
    private var _requestOrderFinishedLocalState by mutableStateOf<OrderState>(OrderState.LoadingState)

    // exposed request order
    val requestOrderFinishedLocalState : State<OrderState> get() = derivedStateOf { _requestOrderFinishedLocalState }

    init {
        viewModelScope.launch {
            // add some delay for better transition
            delay(600)

            try {
                // get finished order by user id
                val getFinishedOrder : List<OrderModel> = orderRemoteUseCase.getFinishedOrderUseCase(
                    userRequestId = sharedPreferences.getString(Constants.USER_ID, "") ?: ""
                )

                // get finished request order by user id
                val getFinishedRequestOrder : List<OrderModel> = orderRemoteUseCase.getFinishedRequestOrderUseCase(
                    userOwnerId = sharedPreferences.getString(Constants.USER_ID, "") ?: ""
                )

                // update finished order state
                _orderFinishedLocalState = OrderState.DataState(
                    data =getFinishedOrder
                )

                // update finished request order state
                _requestOrderFinishedLocalState = OrderState.DataState(
                    data = getFinishedRequestOrder
                )
            } catch (e : Exception) {
                // create error message
                val errMsg = "Error happen ; ${e.message}, ${e.stackTrace}"

                // update finished order state
                _orderFinishedLocalState = OrderState.ErrorState(
                    errMsg = errMsg,
                )

                // update finished request order state
                _requestOrderFinishedLocalState = OrderState.ErrorState(
                    errMsg = errMsg,
                )
            }
        }
    }
}