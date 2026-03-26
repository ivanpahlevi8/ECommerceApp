package com.example.ecommerceapp.data.remote

import com.example.ecommerceapp.data.dto.ResponseDto
import com.example.ecommerceapp.domain.models.ProductModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface ProductRemoteAPI {
    @GET("all-product")
    suspend fun getAllProduct() : ResponseDto<List<ProductModel>>

    @Multipart
    @POST("/create-product")
    suspend fun addProduct(
        @Part("productId") productId: Int,
        @Part("productName") productName: String,
        @Part("productDescription") productDescription: String,
        @Part("productImage") productImage: String,
        @Part image: MultipartBody.Part,
        @Part("productPrice") productPrice: Double,
        @Part("categoryId") categoryId: Int,
        @Part userId: MultipartBody.Part,
    ) : ResponseDto<ProductModel>

    @GET("get-own-products/{userId}")
    suspend fun getOwnProducts(@Path("userId") userId : String) : ResponseDto<List<ProductModel>>

    @GET("onsale-products/{userId}")
    suspend fun getOnSaleProducts(@Path("userId") userId : String) : ResponseDto<List<ProductModel>>

    @DELETE("delete-product/{productId}")
    suspend fun deleteOwnProduct(@Path("productId") productId : String) : ResponseDto<ProductModel>

    @GET("get-product/{productId}")
    suspend fun getProductById(@Path("productId") productId : String) : ResponseDto<ProductModel>

    @Multipart
    @PUT("/update-product")
    suspend fun updateProduct(
        @Part("productId") productId: Int,
        @Part("productName") productName: String,
        @Part("productDescription") productDescription: String,
        @Part("productImage") productImage: String,
        @Part image: MultipartBody.Part,
        @Part("productPrice") productPrice: Double,
        @Part("categoryId") categoryId: Int,
        @Part userId: MultipartBody.Part,
    ) : ResponseDto<ProductModel>
}