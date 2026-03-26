package com.example.ecommerceapp.domain.models

import com.google.gson.annotations.SerializedName

data class ProductModel(
    @SerializedName(value = "productId")
    var productId : String,

    @SerializedName(value = "productName")
    var productName : String,

    @SerializedName(value = "productDescription")
    var productDescription : String,

    @SerializedName(value = "productImage")
    var productImage : String,

    @SerializedName(value = "productPrice")
    var productPrice : Double,

    @SerializedName(value = "categoryId")
    val categoryId : String,

    @SerializedName(value = "userId")
    val productUserId : String,
)
