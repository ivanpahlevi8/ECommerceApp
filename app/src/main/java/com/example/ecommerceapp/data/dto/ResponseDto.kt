package com.example.ecommerceapp.data.dto

import com.google.gson.annotations.SerializedName


data class ResponseDto<T>(
    @SerializedName(value = "message")
    val responseMessage : String,

    @SerializedName(value = "isSuccess")
    val responseIsSuccess : Boolean,

    @SerializedName(value = "result")
    val responseResult : T,
)
