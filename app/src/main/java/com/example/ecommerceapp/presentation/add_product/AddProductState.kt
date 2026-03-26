package com.example.ecommerceapp.presentation.add_product

import com.example.ecommerceapp.domain.models.ProductModel

sealed class AddProductState {
    data class DataState(val data : ProductModel) : AddProductState()
    data class ErrorState(val errMsg : String) : AddProductState()
    object LoadingState : AddProductState()
    object IdleState : AddProductState()
}