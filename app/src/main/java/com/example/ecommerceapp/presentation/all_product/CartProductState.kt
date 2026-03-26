package com.example.ecommerceapp.presentation.all_product

import com.example.ecommerceapp.domain.models.cart_models.CartDetailRequestModel

sealed class CartProductState {
    data class DataState(val data : CartDetailRequestModel) : CartProductState()
    data class ErrorState(val errMsg : String) : CartProductState()
    object LoadingState : CartProductState()
    object IdleState : CartProductState()
}