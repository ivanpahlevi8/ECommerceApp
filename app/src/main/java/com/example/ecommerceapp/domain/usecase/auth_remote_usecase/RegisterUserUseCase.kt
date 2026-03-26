package com.example.ecommerceapp.domain.usecase.auth_remote_usecase

import com.example.ecommerceapp.domain.models.RegisterUserRequestModel
import com.example.ecommerceapp.domain.models.UserModel
import com.example.ecommerceapp.domain.repositories.AuthRemoteRepository

class RegisterUserUseCase(
    private val authRemoteRepository: AuthRemoteRepository
) {
    suspend operator fun invoke(registerUser : RegisterUserRequestModel) : UserModel {
        return authRemoteRepository.registerUser(
            registerRequest = registerUser,
        )
    }
}