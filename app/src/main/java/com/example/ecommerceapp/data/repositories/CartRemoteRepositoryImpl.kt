package com.example.ecommerceapp.data.repositories

import android.util.Log
import com.example.ecommerceapp.data.dto.ResponseDto
import com.example.ecommerceapp.data.remote.CartRemoteAPI
import com.example.ecommerceapp.domain.models.cart_models.CartDetailRequestModel
import com.example.ecommerceapp.domain.models.cart_models.CartModel
import com.example.ecommerceapp.domain.repositories.CartRemoteRepository
import retrofit2.HttpException

class CartRemoteRepositoryImpl(
    private val cartRemoteAPI: CartRemoteAPI
) : CartRemoteRepository {
    override suspend fun getCart(userId: String): CartModel? {
        try{
            // get cart model
            val response : ResponseDto<CartModel?> = cartRemoteAPI.getCart(
                userId = userId
            )

            // check response
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

    override suspend fun addCartDetail(cartDetailRequestModel: CartDetailRequestModel): CartDetailRequestModel {
        try{
            // add cart detail
            val response : ResponseDto<CartDetailRequestModel> = cartRemoteAPI.addCartDetail(
                cartDetailRequestModel = cartDetailRequestModel,
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

    override suspend fun deleteCartDetail(cartDetailId: Int): String {
        try{
            // delete cart detail
            val response : ResponseDto<String> = cartRemoteAPI.deleteCartDetail(
                cartDetailId
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

    override suspend fun clearCartDetail(cartHeaderId: Int): String {
        try{
            // clear cart detail
            val response : ResponseDto<String> = cartRemoteAPI.clearCartDetail(
                cartHeaderId
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

    override suspend fun deleteCartHeader(cartHeaderId: Int): String {
        try{
            // delete cart header
            val response : ResponseDto<String> = cartRemoteAPI.deleteCartHeader(
                cartHeaderId
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