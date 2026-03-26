package com.example.ecommerceapp.domain.models

import com.google.gson.annotations.SerializedName

data class UpdateProfileModel(
    @SerializedName(value = "userName")
    val userName : String,

    @SerializedName(value = "firstName")
    val userFirstName : String,

    @SerializedName(value = "lastName")
    val userLastName : String,

    @SerializedName(value = "phoneNumber")
    val userPhoneNumber : String,
)
