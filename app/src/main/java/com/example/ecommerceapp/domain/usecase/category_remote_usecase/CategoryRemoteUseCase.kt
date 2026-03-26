package com.example.ecommerceapp.domain.usecase.category_remote_usecase

import com.example.ecommerceapp.domain.repositories.CategoryRemoteRepository

data class CategoryRemoteUseCase(
    val getAllCategoryUseCase: GetAllCategoryUseCase,
    val getCategoryUseCase: GetCategoryUseCase,
)