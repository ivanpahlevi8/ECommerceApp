package com.example.ecommerceapp.domain.usecase.product_remote_usecase

import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.domain.repositories.ProductRemoteRepository

class GetProductByIdUseCase(
    private val productRemoteRepository: ProductRemoteRepository
) {
    suspend operator fun invoke(productId : String) : ProductModel {
        return productRemoteRepository.getProductById(
            productId = productId,
        )
    }
}