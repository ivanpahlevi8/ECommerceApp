package com.example.ecommerceapp.domain.repositories

import com.example.ecommerceapp.domain.models.CategoryModel

interface CategoryRemoteRepository {
    // create function to get all category
    suspend fun getAllCategory() : List<CategoryModel>

    // create function to get category
    suspend fun getCategory(categoryId : String) : CategoryModel
}