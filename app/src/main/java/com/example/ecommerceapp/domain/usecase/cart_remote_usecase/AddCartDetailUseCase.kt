package com.example.ecommerceapp.domain.usecase.cart_remote_usecase

import com.example.ecommerceapp.domain.models.cart_models.CartDetailRequestModel
import com.example.ecommerceapp.domain.repositories.CartRemoteRepository

class AddCartDetailUseCase(
    private val cartRemoteRepository: CartRemoteRepository
) {
    suspend operator fun invoke(cartDetailRequestModel: CartDetailRequestModel) : CartDetailRequestModel {
        return cartRemoteRepository.addCartDetail(
            cartDetailRequestModel = cartDetailRequestModel,
        )
    }
}