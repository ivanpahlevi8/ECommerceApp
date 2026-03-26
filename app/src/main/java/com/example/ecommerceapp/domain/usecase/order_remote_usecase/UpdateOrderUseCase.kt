package com.example.ecommerceapp.domain.usecase.order_remote_usecase

import com.example.ecommerceapp.domain.repositories.OrderRemoteRepository

class UpdateOrderUseCase(
    private val orderRemoteRepository: OrderRemoteRepository
) {
    suspend operator fun invoke(
        orderStatus : String,
        orderId : Int
    ) : String {
        return orderRemoteRepository.Updateorder(
            orderStatus, orderId
        )
    }
}