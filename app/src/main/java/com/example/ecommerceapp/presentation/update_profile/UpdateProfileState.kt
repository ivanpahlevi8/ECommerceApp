package com.example.ecommerceapp.presentation.update_profile

import com.example.ecommerceapp.domain.models.UpdateProfileModel

sealed class UpdateProfileState {
    data class DataState(val data  : UpdateProfileModel) : UpdateProfileState()
    data class ErrorState(val errMsg : String) : UpdateProfileState()
    object LoadingState : UpdateProfileState()
    object IdleState : UpdateProfileState()
}