package com.example.ecommerceapp.data.remote

import com.example.ecommerceapp.data.dto.ResponseDto
import com.example.ecommerceapp.domain.models.order_models.OrderCreateRequestModel
import com.example.ecommerceapp.domain.models.order_models.OrderModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface OrderRemoteAPI {
    @POST("create-order")
    suspend fun CreateOrder(@Body orderCreate : OrderCreateRequestModel) : ResponseDto<String>

    @GET("get-order")
    suspend fun GetOrder(@Query("userId") userId : String) : ResponseDto<List<OrderModel>>

    @GET("get-requested-order")
    suspend fun GetRequestedOrder(@Query("ownerUserId") ownerUserId : String) : ResponseDto<List<OrderModel>>

    @PUT("update-order-status")
    suspend fun UpdateOrderStatus(@Query("orderStatus") orderStatus : String, @Query("orderId") orderId : Int) : ResponseDto<String>

    @GET("get-finished-order")
    suspend fun GetFinishedOrder(@Query("userId") userRequestId : String) : ResponseDto<List<OrderModel>>

    @GET("get-finished-request-order")
    suspend fun GetFinishedRequestOrder(@Query("userId") ownerId : String) : ResponseDto<List<OrderModel>>
}