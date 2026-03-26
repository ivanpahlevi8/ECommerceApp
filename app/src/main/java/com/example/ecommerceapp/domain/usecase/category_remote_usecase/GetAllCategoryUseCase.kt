package com.example.ecommerceapp.domain.usecase.category_remote_usecase

import com.example.ecommerceapp.domain.models.CategoryModel
import com.example.ecommerceapp.domain.repositories.CategoryRemoteRepository

class GetAllCategoryUseCase(
    private val categoryRemoteRepository: CategoryRemoteRepository
) {
    suspend operator fun invoke() : List<CategoryModel> {
        return categoryRemoteRepository.getAllCategory()
    }
}