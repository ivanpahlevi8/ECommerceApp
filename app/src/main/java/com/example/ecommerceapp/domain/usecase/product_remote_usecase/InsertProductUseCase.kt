package com.example.ecommerceapp.domain.usecase.product_remote_usecase

import com.example.ecommerceapp.domain.models.InsertProductModel
import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.domain.repositories.ProductRemoteRepository

class InsertProductUseCase(
    private val productRemoteRepository: ProductRemoteRepository
) {
    suspend operator fun invoke(productInsert : InsertProductModel) : ProductModel {
        return productRemoteRepository.insertProduct(
            productInsert = productInsert,
        )
    }
}