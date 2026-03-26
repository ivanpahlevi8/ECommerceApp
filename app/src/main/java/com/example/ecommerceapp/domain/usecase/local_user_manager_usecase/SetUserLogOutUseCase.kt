package com.example.ecommerceapp.domain.usecase.local_user_manager_usecase

import com.example.ecommerceapp.domain.manager.LocalUserManager

class SetUserLogOutUseCase(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.setUserLogout()
    }
}