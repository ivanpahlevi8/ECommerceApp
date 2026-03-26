package com.example.ecommerceapp.domain.models.cart_models

import com.google.gson.annotations.SerializedName

data class CartModel(
    @SerializedName(value = "cartHeader")
    val cartHeader : CartHeaderModel,

    @SerializedName(value = "cartDetailList")
    val cartDetailList : List<CartDetailModel>
)
