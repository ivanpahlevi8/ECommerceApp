package com.example.ecommerceapp.domain.usecase.auth_remote_usecase

import com.example.ecommerceapp.domain.models.LoginUserRequestModel
import com.example.ecommerceapp.domain.models.LoginUserResponseModel
import com.example.ecommerceapp.domain.repositories.AuthRemoteRepository

class LoginUserUseCase(
    private val authRemoteRepository: AuthRemoteRepository
) {
    suspend operator fun invoke(loginUser : LoginUserRequestModel) : LoginUserResponseModel {
        return authRemoteRepository.loginUser(
            loginUser = loginUser
        )
    }
}