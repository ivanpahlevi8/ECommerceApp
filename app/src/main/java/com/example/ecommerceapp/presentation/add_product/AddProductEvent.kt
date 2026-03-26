package com.example.ecommerceapp.presentation.add_product

import com.example.ecommerceapp.domain.models.InsertProductModel

sealed class AddProductEvent {
    data class AddProduct(val productInsert : InsertProductModel) : AddProductEvent()
}