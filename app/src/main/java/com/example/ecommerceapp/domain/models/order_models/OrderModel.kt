package com.example.ecommerceapp.domain.models.order_models

import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.domain.models.UserModel
import com.google.gson.annotations.SerializedName

data class OrderModel(
    @SerializedName(value = "orderId")
    val orderId : Int,

    @SerializedName(value = "userRequesterId")
    val orderUserRequesterId : String,

    @SerializedName(value = "userOwnerId")
    val orderUserOwnerId : String,

    @SerializedName(value = "userOwner")
    val orderUserOwner : UserModel,

    @SerializedName(value = "userRequester")
    val orderUserRequester : UserModel,

    @SerializedName(value = "productId")
    val orderProductId : List<Int>,

    @SerializedName(value = "allProduct")
    val orderAllProduct : List<ProductModel>,

    @SerializedName(value = "orderStatus")
    val orderStatus : String,
)
