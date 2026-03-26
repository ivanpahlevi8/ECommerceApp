package com.example.ecommerceapp.presentation.category_screen

import com.example.ecommerceapp.domain.models.CategoryModel

sealed class CategoryScreenState {
    data class DataState(val data : List<CategoryModel>) : CategoryScreenState()
    data class ErrorState(val errMsg : String) : CategoryScreenState()
    object LoadingState : CategoryScreenState()
}