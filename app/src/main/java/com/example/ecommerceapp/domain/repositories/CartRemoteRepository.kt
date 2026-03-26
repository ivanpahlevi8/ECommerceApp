package com.example.ecommerceapp.domain.repositories

import com.example.ecommerceapp.domain.models.cart_models.CartDetailRequestModel
import com.example.ecommerceapp.domain.models.cart_models.CartModel

interface CartRemoteRepository {
    // create function to get cart
    suspend fun getCart(userId : String) : CartModel?

    // create function to create cart detail
    suspend fun addCartDetail(cartDetailRequestModel: CartDetailRequestModel) : CartDetailRequestModel

    // create function to delete cart detail
    suspend fun deleteCartDetail(cartDetailId : Int) : String

    // create function to clear cart detail
    suspend fun clearCartDetail(cartHeaderId : Int) : String

    // create function to delete cart header
    suspend fun deleteCartHeader(cartHeaderId: Int) : String
}