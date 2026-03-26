package com.example.ecommerceapp.presentation.cart

import com.example.ecommerceapp.domain.models.cart_models.CartModel

sealed class CartState {
    data class DataState<T>(val data : T?) : CartState()
    data class ErrorState(val errMsg : String) : CartState()
    object LoadingState : CartState()
    object IdleState : CartState()
}