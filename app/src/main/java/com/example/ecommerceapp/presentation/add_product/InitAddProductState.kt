package com.example.ecommerceapp.presentation.add_product

import com.example.ecommerceapp.domain.models.CategoryModel

sealed class InitAddProductState {
    data class DataState(val data : List<CategoryModel>) : InitAddProductState()
    data class ErrorState(val errMsg : String) : InitAddProductState()
    object LoadingState : InitAddProductState()
}