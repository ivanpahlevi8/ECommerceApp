package com.example.ecommerceapp.presentation.profile_screen

import android.content.SharedPreferences
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapp.core.value.Constants
import com.example.ecommerceapp.domain.models.UserModel
import com.example.ecommerceapp.domain.usecase.auth_remote_usecase.AuthRemoteUseCase
import com.example.ecommerceapp.presentation.update_profile.UpdateProfileState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class ProfileScreenViewModel @Inject constructor(
    private val authRemoteUseCase: AuthRemoteUseCase,
    private val sharedPreferences: SharedPreferences,
) : ViewModel() {
    // create local state for get profile
    private var _getProfileState by mutableStateOf<ProfileScreenState>(ProfileScreenState.LoadingState)

    // exposed state for get profile
    val getProfileState : State<ProfileScreenState> get() = derivedStateOf { _getProfileState }

    init {
        viewModelScope.launch {
            // add delay for better transition
            delay(500)

            try{
                // get user
                val getUser : UserModel = authRemoteUseCase.getUserUseCase(
                    userName = sharedPreferences.getString(Constants.USER_NAME, "") ?: ""
                )

                // update get user image
                getUser.userImage = sharedPreferences.getString(Constants.USER_IMAGE, "") ?: ""

                // update state into data state
                _getProfileState = ProfileScreenState.DataState(
                    data = getUser
                )
            } catch (e : Exception) {
                // create error message
                val errMsg : String = "Error Happen : ${e.message}, ${e.stackTrace}"

                // update state into error state
                _getProfileState = ProfileScreenState.ErrorState(
                    errMsg = errMsg
                )
            }
        }
    }
}