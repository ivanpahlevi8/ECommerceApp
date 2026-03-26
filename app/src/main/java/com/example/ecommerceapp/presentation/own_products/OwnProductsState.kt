package com.example.ecommerceapp.presentation.own_products

import com.example.ecommerceapp.domain.models.ProductModel

sealed class OwnProductsState {
    data class DataState(val data : List<ProductModel>) : OwnProductsState()
    data class ErrorState(val errMsg : String) : OwnProductsState()
    object LoadingState : OwnProductsState()
}