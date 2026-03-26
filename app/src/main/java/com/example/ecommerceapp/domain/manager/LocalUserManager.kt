package com.example.ecommerceapp.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {
    // create function to set user onboard
    suspend fun setUserOnBoard()
    fun getUserOnBoard() : Flow<Boolean>

    // create function to set user login or not
    suspend fun setUserLogin()
    suspend fun setUserLogout()
    fun getUserLoggedIn() : Flow<Boolean>
}