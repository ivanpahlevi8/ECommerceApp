package com.example.ecommerceapp.domain.models.cart_models

import com.example.ecommerceapp.domain.models.UserModel
import com.google.gson.annotations.SerializedName

data class CartHeaderModel(
    @SerializedName(value = "cartHeaderId")
    val cartHeaderId : String,

    @SerializedName(value = "userId")
    val cartHeaderUserId : String,

    @SerializedName(value = "user")
    val cartHeaderRequesterUser : UserModel,

    @SerializedName(value = "productAmount")
    val cartHeaderProductAmount : Int,

    @SerializedName(value = "productCost")
    val cartHeaderProductCost : Double,
)
