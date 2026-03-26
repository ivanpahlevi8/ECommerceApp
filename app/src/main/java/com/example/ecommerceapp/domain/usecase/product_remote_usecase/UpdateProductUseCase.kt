package com.example.ecommerceapp.domain.usecase.product_remote_usecase

import com.example.ecommerceapp.domain.models.InsertProductModel
import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.domain.repositories.ProductRemoteRepository

class UpdateProductUseCase(
    private val productRemoteRepository: ProductRemoteRepository
) {
    suspend operator fun invoke(productUpdated : InsertProductModel) : ProductModel {
        return productRemoteRepository.updateProduct(
            productUpdate = productUpdated,
        )
    }
}