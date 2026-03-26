package com.example.ecommerceapp.domain.usecase.local_user_manager_usecase

import com.example.ecommerceapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class GetUserOnBoardUseCase(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke() : Flow<Boolean> {
        return localUserManager.getUserOnBoard()
    }
}