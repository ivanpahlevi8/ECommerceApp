package com.example.ecommerceapp.domain.usecase.order_remote_usecase

import com.example.ecommerceapp.domain.models.order_models.OrderCreateRequestModel
import com.example.ecommerceapp.domain.repositories.OrderRemoteRepository

class CreateOrderUseCase(
    private val orderRemoteRepository: OrderRemoteRepository
) {
    suspend operator fun invoke(orderRequest : OrderCreateRequestModel) : String {
        return orderRemoteRepository.CreateOrder(
            orderRequest = orderRequest
        )
    }
}