package com.example.ecommerceapp.data.repositories

import com.example.ecommerceapp.data.dto.ResponseDto
import com.example.ecommerceapp.data.remote.CategoryRemoteAPI
import com.example.ecommerceapp.domain.models.CategoryModel
import com.example.ecommerceapp.domain.repositories.CategoryRemoteRepository

class CategoryRemoteRepositoryImpl(
    private val categoryRemoteAPI: CategoryRemoteAPI,
) : CategoryRemoteRepository {
    override suspend fun getAllCategory(): List<CategoryModel> {
        // get category list
        val response : ResponseDto<List<CategoryModel>> = categoryRemoteAPI.getAllCategory()

        // check weather response is success or not
        if(!response.responseIsSuccess) {
            throw Exception(response.responseMessage)
        }

        // return value
        return response.responseResult
    }

    override suspend fun getCategory(categoryId: String): CategoryModel {
        // get category
        val response : ResponseDto<CategoryModel> = categoryRemoteAPI.getCategory(categoryId = categoryId)

        // check on response
        if(!response.responseIsSuccess) {
            throw Exception(response.responseMessage)
        }

        // return value
        return response.responseResult
    }
}