package com.example.ecommerceapp.domain.models

import android.net.Uri
import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody

data class RegisterUserRequestModel(
    val userEmail : String,
    val userPassword : String,
    val userFirstName : String,
    val userLastName : String,
    val userPhoneNumber : String,
    val userImageFile : MultipartBody.Part,
    val username : String,
)
