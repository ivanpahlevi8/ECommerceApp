package com.example.ecommerceapp.domain.usecase.auth_remote_usecase

import com.example.ecommerceapp.domain.models.UpdateProfileModel
import com.example.ecommerceapp.domain.models.UserModel
import com.example.ecommerceapp.domain.repositories.AuthRemoteRepository

class UpdateUserProfileUseCase(
    private val authRemoteRepository: AuthRemoteRepository
) {
    suspend operator fun invoke(userProfile : UpdateProfileModel) : UserModel {
        return authRemoteRepository.updateUserProfile(
            userProfile = userProfile,
        )
    }
}