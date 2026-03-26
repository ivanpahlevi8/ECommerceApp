package com.example.ecommerceapp.domain.repositories

import com.example.ecommerceapp.domain.models.order_models.OrderCreateRequestModel
import com.example.ecommerceapp.domain.models.order_models.OrderModel

interface OrderRemoteRepository {
    // create function to create order
    suspend fun CreateOrder(orderRequest : OrderCreateRequestModel) : String

    // create function to get order
    suspend fun GetOrder(userId : String) : List<OrderModel>

    // create function to get requested order
    suspend fun GetRequestedOrder(userOwnerId : String) : List<OrderModel>

    // create function to update order status
    suspend fun Updateorder(orderStatus : String, orderId : Int) : String

    // create function to get order finished
    suspend fun GetFinishedOrder(userRequestId : String) : List<OrderModel>

    // create function to get finished request order
    suspend fun GetFinishedRequestOrder(userOwnerId : String) : List<OrderModel>
}