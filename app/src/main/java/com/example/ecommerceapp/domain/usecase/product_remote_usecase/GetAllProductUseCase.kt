package com.example.ecommerceapp.domain.usecase.product_remote_usecase

import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.domain.repositories.ProductRemoteRepository

class GetAllProductUseCase(
    private val productRemoteRepository: ProductRemoteRepository
) {
    suspend operator fun invoke() : List<ProductModel> {
        return productRemoteRepository.getAllProduct()
    }
}