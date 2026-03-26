package com.example.ecommerceapp.presentation.own_products_update

import com.example.ecommerceapp.domain.models.InsertProductModel

sealed class OwnProductsUpdateEvent {
    data class OnUpdate(val updateProduct : InsertProductModel) : OwnProductsUpdateEvent()
}