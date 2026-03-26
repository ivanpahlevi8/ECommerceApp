package com.example.ecommerceapp.domain.usecase.cart_remote_usecase

data class CartRemoteUseCase(
    val getCartUseCase: GetCartUseCase,
    val addCartDetailUseCase: AddCartDetailUseCase,
    val deleteCartDetailUseCase: DeleteCartDetailUseCase,
    val clearCartDetailUseCase: ClearCartDetailUseCase,
    val deleteCartHeaderUseCase: DeleteCartHeaderUseCase,
)