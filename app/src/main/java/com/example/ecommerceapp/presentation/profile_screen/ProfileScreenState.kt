package com.example.ecommerceapp.presentation.profile_screen

import com.example.ecommerceapp.domain.models.UserModel

sealed class ProfileScreenState {
    data class DataState(val data : UserModel) : ProfileScreenState()
    data class ErrorState(val errMsg : String) : ProfileScreenState()
    object LoadingState : ProfileScreenState()
}