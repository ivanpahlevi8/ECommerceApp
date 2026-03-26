package com.example.ecommerceapp.data.repositories

import android.util.Log
import com.example.ecommerceapp.data.dto.ResponseDto
import com.example.ecommerceapp.data.remote.OrderRemoteAPI
import com.example.ecommerceapp.domain.models.order_models.OrderCreateRequestModel
import com.example.ecommerceapp.domain.models.order_models.OrderModel
import com.example.ecommerceapp.domain.repositories.OrderRemoteRepository
import retrofit2.HttpException

class OrderRemoteRepositoryImpl(
    private val orderRemoteAPI: OrderRemoteAPI
) : OrderRemoteRepository {
    override suspend fun CreateOrder(orderRequest: OrderCreateRequestModel): String {
        try{
            // create order
            val response : ResponseDto<String> = orderRemoteAPI.CreateOrder(
                orderCreate = orderRequest
            )

            // check on response
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

    override suspend fun GetOrder(userId: String): List<OrderModel> {
        try{
            // get order
            val response : ResponseDto<List<OrderModel>> = orderRemoteAPI.GetOrder(
                userId = userId,
            )

            // check on response
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

    override suspend fun GetRequestedOrder(userOwnerId: String): List<OrderModel> {
        try{
            // get order
            val response : ResponseDto<List<OrderModel>> = orderRemoteAPI.GetRequestedOrder(
                ownerUserId = userOwnerId,
            )

            // check on response
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

    override suspend fun Updateorder(orderStatus: String, orderId: Int): String {
        try{
            // update order
            val response : ResponseDto<String> = orderRemoteAPI.UpdateOrderStatus(
                orderStatus = orderStatus,
                orderId = orderId
            )

            // check on response
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

    override suspend fun GetFinishedOrder(userRequestId: String): List<OrderModel> {
        try{
            // get finished order
            val response : ResponseDto<List<OrderModel>> = orderRemoteAPI.GetFinishedOrder(
                userRequestId = userRequestId
            )

            // check on response
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

    override suspend fun GetFinishedRequestOrder(userOwnerId: String): List<OrderModel> {
        try{
            // get finished order
            val response : ResponseDto<List<OrderModel>> = orderRemoteAPI.GetFinishedRequestOrder(
                ownerId = userOwnerId
            )

            // check on response
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