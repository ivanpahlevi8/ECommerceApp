package com.example.ecommerceapp.domain.models

import com.google.gson.annotations.SerializedName

data class LoginUserRequestModel(
    @SerializedName(value = "email")
    val loginEmail : String,

    @SerializedName(value = "password")
    val loginPassword : String,
)
