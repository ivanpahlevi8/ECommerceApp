package com.example.ecommerceapp.domain.usecase.local_user_manager_usecase

data class LocalUserManagerUseCase(
    val getUserOnBoardUseCase: GetUserOnBoardUseCase,
    val setUserOnBoardUseCase: SetUserOnBoardUseCase,
    val setUserLoginUseCase: SetUserLoginUseCase,
    val setUserLogOutUseCase: SetUserLogOutUseCase,
    val getUserLoggedInUseCase: GetUserLoggedInUseCase,
)
