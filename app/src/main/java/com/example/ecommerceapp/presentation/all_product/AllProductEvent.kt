package com.example.ecommerceapp.presentation.all_product

import com.example.ecommerceapp.domain.models.cart_models.CartDetailRequestModel

sealed class AllProductEvent {
    data class AddCartEvent(val cartDetailRequestModel: CartDetailRequestModel) : AllProductEvent()
}