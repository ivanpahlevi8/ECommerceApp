package com.example.ecommerceapp.domain.usecase.order_remote_usecase

data class OrderRemoteUseCase(
    val createOrderUseCase: CreateOrderUseCase,
    val getOrderUseCase: GetOrderUseCase,
    val getRequestedOrderUseCase: GetRequestedOrderUseCase,
    val updateOrderUseCase: UpdateOrderUseCase,
    val getFinishedOrderUseCase: GetFinishedOrderUseCase,
    val getFinishedRequestOrderUseCase: GetFinishedRequestOrderUseCase,
)
