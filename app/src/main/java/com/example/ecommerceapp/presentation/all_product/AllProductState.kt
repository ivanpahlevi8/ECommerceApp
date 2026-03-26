package com.example.ecommerceapp.presentation.all_product

import com.example.ecommerceapp.domain.models.ProductModel

sealed class AllProductState {
    data class DataState(val data : List<ProductModel>) : AllProductState()
    data class ErrorState(val errMsg : String) : AllProductState()
    object LoadingState : AllProductState()
}