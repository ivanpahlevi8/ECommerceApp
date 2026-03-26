package com.example.ecommerceapp.presentation.update_profile

import com.example.ecommerceapp.domain.models.UpdateProfileModel

sealed class UpdateProfileEvent {
    data class OnUpdate(val userProfile : UpdateProfileModel) : UpdateProfileEvent()
}