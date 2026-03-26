package com.example.ecommerceapp.domain.usecase.cart_remote_usecase

import com.example.ecommerceapp.domain.repositories.CartRemoteRepository

class ClearCartDetailUseCase(
    private val cartRemoteRepository: CartRemoteRepository
) {
    suspend operator fun invoke(cartHeaderId : Int) : String {
        return cartRemoteRepository.clearCartDetail(
            cartHeaderId = cartHeaderId
        );
    }
}