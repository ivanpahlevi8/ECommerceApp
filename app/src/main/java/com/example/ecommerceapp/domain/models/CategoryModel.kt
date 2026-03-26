package com.example.ecommerceapp.domain.models

import com.google.gson.annotations.SerializedName

data class CategoryModel(
    @SerializedName(value = "categoryId")
    val categoryId : String,

    @SerializedName(value = "categoryName")
    val categoryName : String,

    @SerializedName(value = "categoryDescription")
    val categoryDescription : String,

    @SerializedName(value = "categoryImageUrl")
    val categoryImageUrl : String,
)
