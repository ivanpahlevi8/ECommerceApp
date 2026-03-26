package com.example.ecommerceapp.presentation.order

sealed class OrderEvent {
    data class OnApprove(val orderId : Int) : OrderEvent()
    data class OnCancel(val orderId: Int) : OrderEvent()
}