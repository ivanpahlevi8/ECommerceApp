package com.example.ecommerceapp.domain.usecase.cart_remote_usecase

import com.example.ecommerceapp.domain.repositories.CartRemoteRepository

class DeleteCartDetailUseCase(
    private val cartRemoteRepository: CartRemoteRepository
) {
    suspend operator fun invoke(cartDetailId : Int) : String {
        return cartRemoteRepository.deleteCartDetail(
            cartDetailId = cartDetailId
        )
    }
}