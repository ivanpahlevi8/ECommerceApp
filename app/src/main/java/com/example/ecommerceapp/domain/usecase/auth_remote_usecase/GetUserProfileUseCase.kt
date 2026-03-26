package com.example.ecommerceapp.domain.usecase.auth_remote_usecase

import android.util.Log
import com.example.ecommerceapp.core.value.Constants
import com.example.ecommerceapp.domain.models.UserModel
import com.example.ecommerceapp.domain.repositories.AuthRemoteRepository

class GetUserProfileUseCase(
    private val authRemoteRepository: AuthRemoteRepository
) {
    suspend operator fun invoke(userName : String) : UserModel {
        return authRemoteRepository.getUserProfile(
            userName = userName
        )
    }
}