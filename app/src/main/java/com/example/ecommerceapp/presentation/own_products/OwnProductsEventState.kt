package com.example.ecommerceapp.presentation.own_products

import com.example.ecommerceapp.domain.models.ProductModel

sealed class OwnProductsEventState {
    data class DataState(val data : ProductModel) : OwnProductsEventState()
    data class ErrorState(val errMsg : String) : OwnProductsEventState()
    object LoadingState : OwnProductsEventState()
    object IdleState : OwnProductsEventState()
}