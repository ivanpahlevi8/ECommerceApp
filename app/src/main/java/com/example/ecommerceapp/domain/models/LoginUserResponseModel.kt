package com.example.ecommerceapp.domain.models

import com.google.gson.annotations.SerializedName

data class LoginUserResponseModel(
    @SerializedName(value = "user")
    val userModel: UserModel,

    @SerializedName(value = "userToken")
    val userToken : String,
)
