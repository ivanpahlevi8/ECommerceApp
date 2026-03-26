package com.example.ecommerceapp.data.remote

import com.example.ecommerceapp.data.dto.ResponseDto
import com.example.ecommerceapp.domain.models.cart_models.CartDetailRequestModel
import com.example.ecommerceapp.domain.models.cart_models.CartModel
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface CartRemoteAPI {
    @GET("get-cart/{userId}")
    suspend fun getCart(@Path("userId") userId : String) : ResponseDto<CartModel?>

    @POST("add-cart-detail")
    suspend fun addCartDetail(@Body cartDetailRequestModel: CartDetailRequestModel) : ResponseDto<CartDetailRequestModel>

    @DELETE("delete-cart-detail")
    suspend fun deleteCartDetail(@Query("cartDetailId") cartDetailId : Int) : ResponseDto<String>

    @DELETE("clear-cart-detail")
    suspend fun clearCartDetail(@Query("cartHeaderId") cartHeaderId : Int) : ResponseDto<String>

    @DELETE("delete-cart-header")
    suspend fun deleteCartHeader(@Query("cartHeaderId") cartHeaderId : Int) : ResponseDto<String>
}