package com.example.ecommerceapp.data.repositories

import android.util.Log
import com.example.ecommerceapp.data.dto.ResponseDto
import com.example.ecommerceapp.data.remote.ProductRemoteAPI
import com.example.ecommerceapp.domain.models.InsertProductModel
import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.domain.repositories.ProductRemoteRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.HttpException

class ProductRemoteRepositoryImpl(
    private val productRemoteAPI: ProductRemoteAPI,
) : ProductRemoteRepository {
    override suspend fun getAllProduct(): List<ProductModel> {
        // get all product
        val response : ResponseDto<List<ProductModel>> = productRemoteAPI.getAllProduct()

        // check response
        if(!response.responseIsSuccess) {
            throw Exception(response.responseMessage)
        }

        return response.responseResult
    }

    override suspend fun insertProduct(productInsert: InsertProductModel): ProductModel {
        // insert product
        try{
            val userIdPart = MultipartBody.Part.createFormData("userId", productInsert.userId.trim())
            val response = productRemoteAPI.addProduct(
                productId = productInsert.productId.toInt(),
                productName = productInsert.productName,
                productDescription = productInsert.productDescription,
                productImage = "a", // Placeholder as per your requirement
                image = productInsert.image,
                productPrice = productInsert.productPrice.toDouble(),
                categoryId = productInsert.categoryId.toInt(),
                userId = userIdPart
            )

            // check for response
            if(!response.responseIsSuccess) {
                throw Exception(response.responseMessage)
            }

            return response.responseResult
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            Log.e("CHECK", "SERVER ERROR DETAIL: $errorBody")
            throw Exception(errorBody ?: e.message())
        } catch (e: Exception) {
            Log.e("CHECK", "GENERAL ERROR: ${e.message}")
            throw e
        }
    }

    override suspend fun getOwnProducts(userId: String): List<ProductModel> {
        try{
            // get own products
            val getResponse : ResponseDto<List<ProductModel>> = productRemoteAPI.getOwnProducts(
                userId = userId
            )

            // check on response
            if(!getResponse.responseIsSuccess) {
                throw Exception(getResponse.responseMessage)
            }

            return getResponse.responseResult
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            Log.e("CHECK", "SERVER ERROR DETAIL: $errorBody")
            throw Exception(errorBody ?: e.message())
        } catch (e: Exception) {
            Log.e("CHECK", "GENERAL ERROR: ${e.message}")
            throw e
        }
    }

    override suspend fun getOnSaleProducts(userId: String): List<ProductModel> {
        try{
            // get on sale products
            val response : ResponseDto<List<ProductModel>> = productRemoteAPI.getOnSaleProducts(
                userId = userId,
            )

            // check on response
            if(!response.responseIsSuccess) {
                throw Exception(response.responseMessage)
            }

            // return data
            return response.responseResult
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            Log.e("CHECK", "SERVER ERROR DETAIL: $errorBody")
            throw Exception(errorBody ?: e.message())
        } catch (e: Exception) {
            Log.e("CHECK", "GENERAL ERROR: ${e.message}")
            throw e
        }
    }

    override suspend fun deleteOwnProduct(productId: String): ProductModel {
        try{
            // delete product
            val response : ResponseDto<ProductModel> = productRemoteAPI.deleteOwnProduct(
                productId = productId
            )

            // check on response
            if(!response.responseIsSuccess) {
                // throw an error
                throw Exception(response.responseMessage)
            }

            return response.responseResult
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            Log.e("CHECK", "SERVER ERROR DETAIL: $errorBody")
            throw Exception(errorBody ?: e.message())
        } catch (e: Exception) {
            Log.e("CHECK", "GENERAL ERROR: ${e.message}")
            throw e
        }
    }

    override suspend fun getProductById(productId: String): ProductModel {
        try{
            // get product by id
            val response : ResponseDto<ProductModel> = productRemoteAPI.getProductById(
                productId = productId
            )

            // check on response
            if(!response.responseIsSuccess) {
                throw Exception(response.responseMessage)
            }

            // return result
            return response.responseResult
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            Log.e("CHECK", "SERVER ERROR DETAIL: $errorBody")
            throw Exception(errorBody ?: e.message())
        } catch (e: Exception) {
            Log.e("CHECK", "GENERAL ERROR: ${e.message}")
            throw e
        }
    }

    override suspend fun updateProduct(productUpdate: InsertProductModel): ProductModel {
        try{
            val userIdPart = MultipartBody.Part.createFormData("userId", productUpdate.userId.trim())
            val response = productRemoteAPI.updateProduct(
                productId = productUpdate.productId.toInt(),
                productName = productUpdate.productName,
                productDescription = productUpdate.productDescription,
                productImage = "a", // Placeholder as per your requirement
                image = productUpdate.image,
                productPrice = productUpdate.productPrice.toDouble(),
                categoryId = productUpdate.categoryId.toInt(),
                userId = userIdPart
            )

            // check for response
            if(!response.responseIsSuccess) {
                throw Exception(response.responseMessage)
            }

            return response.responseResult
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            Log.e("CHECK", "SERVER ERROR DETAIL: $errorBody")
            throw Exception(errorBody ?: e.message())
        } catch (e: Exception) {
            Log.e("CHECK", "GENERAL ERROR: ${e.message}")
            throw e
        }
    }
}