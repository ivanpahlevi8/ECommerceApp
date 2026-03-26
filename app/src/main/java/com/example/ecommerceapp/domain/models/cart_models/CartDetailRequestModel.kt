package com.example.ecommerceapp.domain.models.cart_models

import com.google.gson.annotations.SerializedName

data class CartDetailRequestModel(
    @SerializedName(value = "cartDetailId")
    var cartDetailId : Int,

    @SerializedName(value = "cartHeaderId")
    var cartHeaderId : Int,

    @SerializedName(value = "productId")
    var productId : Int,

    @SerializedName(value = "userOwnerId")
    var userOwnerId : String,

    @SerializedName(value = "userRequestorId")
    var userRequesterId : String,
)
