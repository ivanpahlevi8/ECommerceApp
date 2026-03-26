package com.example.ecommerceapp.domain.repositories

import com.example.ecommerceapp.domain.models.InsertProductModel
import com.example.ecommerceapp.domain.models.ProductModel

interface ProductRemoteRepository {
    // create function to get all product
    suspend fun getAllProduct() : List<ProductModel>

    // create function to insert product
    suspend fun insertProduct(productInsert : InsertProductModel) : ProductModel

    // create function to get product by
    suspend fun getOwnProducts(userId : String) : List<ProductModel>

    // create function to get on sale product
    suspend fun getOnSaleProducts(userId : String) : List<ProductModel>

    // create function to delete own product
    suspend fun deleteOwnProduct(productId : String) : ProductModel

    // create function to get product by id
    suspend fun getProductById(productId : String) : ProductModel

    // create function to update product
    suspend fun updateProduct(productUpdate : InsertProductModel) : ProductModel
}