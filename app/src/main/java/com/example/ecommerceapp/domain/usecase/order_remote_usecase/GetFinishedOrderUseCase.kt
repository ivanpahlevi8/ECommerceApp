package com.example.ecommerceapp.domain.usecase.order_remote_usecase

import com.example.ecommerceapp.domain.models.order_models.OrderModel
import com.example.ecommerceapp.domain.repositories.OrderRemoteRepository

class GetFinishedOrderUseCase(
    private val orderRemoteRepository: OrderRemoteRepository
) {
    suspend operator fun invoke(
        userRequestId : String
    ) : List<OrderModel> {
        return orderRemoteRepository.GetFinishedOrder(
            userRequestId = userRequestId
        )
    }
}