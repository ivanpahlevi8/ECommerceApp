package com.example.ecommerceapp.domain.models

import okhttp3.MultipartBody

data class InsertProductModel(
    var productId : String,
    var productName : String,
    var productDescription : String,
    var productImage : String,
    var image : MultipartBody.Part,
    var productPrice : String,
    var categoryId : String,
    var userId : String,
)