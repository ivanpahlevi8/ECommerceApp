package com.example.ecommerceapp.domain.usecase.cart_remote_usecase

import com.example.ecommerceapp.domain.models.cart_models.CartModel
import com.example.ecommerceapp.domain.repositories.CartRemoteRepository

class GetCartUseCase(
    private val cartRemoteRepository: CartRemoteRepository
) {
    suspend operator fun invoke(userId : String) : CartModel? {
        return cartRemoteRepository.getCart(
            userId
        )
    }
}