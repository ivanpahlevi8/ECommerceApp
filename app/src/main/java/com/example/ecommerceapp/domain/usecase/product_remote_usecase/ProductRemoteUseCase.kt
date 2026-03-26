package com.example.ecommerceapp.domain.usecase.product_remote_usecase

data class ProductRemoteUseCase(
    val getAllProductUseCase: GetAllProductUseCase,
    val insertProductUseCase: InsertProductUseCase,
    val getOwnProductsUseCase: GetOwnProductsUseCase,
    val deleteOwnProductUseCase: DeleteOwnProductUseCase,
    val getProductByIdUseCase: GetProductByIdUseCase,
    val updateProductUseCase: UpdateProductUseCase,
    val getOnSaleProductUseCase: GetOnSaleProductUseCase,
)
