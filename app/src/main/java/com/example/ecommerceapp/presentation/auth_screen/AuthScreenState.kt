package com.example.ecommerceapp.presentation.auth_screen

import com.example.ecommerceapp.domain.models.UserModel

sealed class AuthScreenState {
    data class DataState<T>(val userModel : T) : AuthScreenState()
    data class ErrorState(val errMsg : String) : AuthScreenState()
    object LoadingState : AuthScreenState()
    object IdleState : AuthScreenState()
}