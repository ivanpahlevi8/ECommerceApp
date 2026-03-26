package com.example.ecommerceapp.domain.models.cart_models

import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.domain.models.UserModel
import com.google.gson.annotations.SerializedName

data class CartDetailModel(
    @SerializedName(value = "cartDetailId")
    val cartDetailId : Int,

    @SerializedName(value = "cartHeaderId")
    val cartHeaderId : Int,

    @SerializedName(value = "productId")
    val cartDetailProductId : Int,

    @SerializedName(value = "product")
    val cartDetailProduct : ProductModel,

    @SerializedName(value = "userOwnerId")
    val cartDetailUserOwnerId : String,

    @SerializedName(value = "userOwner")
    val cartDetailUserOwner : UserModel,

    @SerializedName(value = "userRequestorId")
    val cartDetailUserRequesterId : String,

    @SerializedName(value = "userRequestor")
    val cartDetailRequesterOwner : UserModel,
)
