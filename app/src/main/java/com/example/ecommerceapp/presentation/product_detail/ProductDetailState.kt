package com.example.ecommerceapp.presentation.product_detail

import com.example.ecommerceapp.domain.models.CategoryModel
import com.example.ecommerceapp.domain.models.ProductModel

sealed class ProductDetailState {
    data class DataState(val product : ProductModel, val category : CategoryModel) : ProductDetailState()
    data class ErrorState(val errMsg : String) : ProductDetailState()
    object LoadingState : ProductDetailState()
}