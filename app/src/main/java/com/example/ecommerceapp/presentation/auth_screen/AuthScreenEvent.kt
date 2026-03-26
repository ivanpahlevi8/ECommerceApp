package com.example.ecommerceapp.presentation.auth_screen

import com.example.ecommerceapp.domain.models.LoginUserRequestModel
import com.example.ecommerceapp.domain.models.RegisterUserRequestModel

sealed class AuthScreenEvent {
    data class OnRegister(val registerModel : RegisterUserRequestModel) : AuthScreenEvent()
    data class OnLogin(val loginUser : LoginUserRequestModel) : AuthScreenEvent()
}