package com.example.ecommerceapp.presentation.own_products_update

import com.example.ecommerceapp.domain.models.CategoryModel
import com.example.ecommerceapp.domain.models.ProductModel

sealed class OwnProductsUpdateState {
    data class DataState(val data : ProductModel, val categoryList : List<CategoryModel>) : OwnProductsUpdateState()
    data class ErrorState(val errMsg : String) : OwnProductsUpdateState()
    object LoadingState : OwnProductsUpdateState()
    object IdleState : OwnProductsUpdateState()
}