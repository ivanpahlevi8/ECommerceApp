package com.example.ecommerceapp.domain.models

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName(value = "firstName")
    var userFirstName : String,

    @SerializedName(value = "lastName")
    var userLastName : String,

    @SerializedName(value = "email")
    var userEmail : String,

    @SerializedName(value = "userName")
    var userName : String,

    @SerializedName(value = "imageUrl")
    var userImage : String,

    @SerializedName(value = "phoneNumber")
    val userPhoneNumber : String,

    @SerializedName(value = "id")
    val userId : String,
)
