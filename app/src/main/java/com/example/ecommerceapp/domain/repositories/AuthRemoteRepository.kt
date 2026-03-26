package com.example.ecommerceapp.domain.repositories

import com.example.ecommerceapp.domain.models.LoginUserRequestModel
import com.example.ecommerceapp.domain.models.LoginUserResponseModel
import com.example.ecommerceapp.domain.models.RegisterUserRequestModel
import com.example.ecommerceapp.domain.models.UpdateProfileModel
import com.example.ecommerceapp.domain.models.UserModel

interface AuthRemoteRepository {
    // create function to register user
    suspend fun registerUser(registerRequest : RegisterUserRequestModel) : UserModel

    // create function to login user
    suspend fun loginUser(loginUser : LoginUserRequestModel) : LoginUserResponseModel

    // create function to get user profile
    suspend fun getUserProfile(userName : String) : UserModel

    // create function to update user profile
    suspend fun updateUserProfile(userProfile : UpdateProfileModel) : UserModel
}