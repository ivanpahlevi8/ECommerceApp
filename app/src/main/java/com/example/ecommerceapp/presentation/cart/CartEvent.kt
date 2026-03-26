package com.example.ecommerceapp.presentation.cart

import com.example.ecommerceapp.domain.models.order_models.OrderCreateRequestModel

sealed class CartEvent {
    data class OnDeleteCartDetail(val cartDetailId : Int) : CartEvent()
    data class OnClearCartDetail(val cartHeaderId : Int) : CartEvent()
    data class OnDeleteCartHeader(val cartHeaderId: Int) : CartEvent()
    data class OnOrderCart(val orderCreateRequestModel: OrderCreateRequestModel) : CartEvent()
}