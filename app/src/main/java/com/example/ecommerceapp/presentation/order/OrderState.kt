package com.example.ecommerceapp.presentation.order

import com.example.ecommerceapp.domain.models.order_models.OrderModel

sealed class OrderState {
    data class DataState(val data : List<OrderModel>) : OrderState()
    data class ErrorState(val errMsg : String) : OrderState()
    object LoadingState : OrderState()
}