package com.example.ecommerceapp.data.remote

import com.example.ecommerceapp.data.dto.ResponseDto
import com.example.ecommerceapp.domain.models.CategoryModel
import retrofit2.http.GET
import retrofit2.http.Path

interface CategoryRemoteAPI {
    // function to get all category
    @GET("get-all-category")
    suspend fun getAllCategory() : ResponseDto<List<CategoryModel>>

    // function to get category based on category id
    @GET("get-category/{categoryId}")
    suspend fun getCategory(@Path("categoryId") categoryId : String) : ResponseDto<CategoryModel>
}