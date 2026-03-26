package com.example.ecommerceapp.domain.usecase.auth_remote_usecase

data class AuthRemoteUseCase(
    val registerUserUseCase: RegisterUserUseCase,
    val loginUserUseCase: LoginUserUseCase,
    val getUserUseCase : GetUserProfileUseCase,
    val updateUserProfileUseCase : UpdateUserProfileUseCase
)
