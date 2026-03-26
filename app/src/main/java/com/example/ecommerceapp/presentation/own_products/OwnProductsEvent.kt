package com.example.ecommerceapp.presentation.own_products

import com.example.ecommerceapp.domain.models.InsertProductModel
import com.example.ecommerceapp.domain.models.ProductModel

sealed class OwnProductsEvent {
    data class OnDelete(val data : ProductModel) : OwnProductsEvent()
}