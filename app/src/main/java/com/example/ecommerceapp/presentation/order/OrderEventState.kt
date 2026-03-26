package com.example.ecommerceapp.presentation.order

sealed class OrderEventState {
    data class DataState(val data : String) : OrderEventState()
    data class ErrorState(val errMsg : String) : OrderEventState()
    object LoadingState : OrderEventState()
    object IdleState : OrderEventState()
}