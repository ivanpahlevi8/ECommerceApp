package com.example.ecommerceapp.presentation.update_profile

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapp.domain.models.UpdateProfileModel
import com.example.ecommerceapp.domain.models.UserModel
import com.example.ecommerceapp.domain.usecase.auth_remote_usecase.AuthRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class UpdateProfileViewModel @Inject constructor(
    private val authRemoteUseCase: AuthRemoteUseCase,
    savedStateHandle : SavedStateHandle
) : ViewModel() {
    // create state for init data on entry
    private var _initEntryState by mutableStateOf<UpdateProfileState>(UpdateProfileState.LoadingState)

    // exposes state for init data on entry
    val initEntryState : State<UpdateProfileState> get() = derivedStateOf { _initEntryState }

    // create local state for update profile
    private var _updateProfileState by mutableStateOf<UpdateProfileState>(UpdateProfileState.IdleState)

    // exposed state for update profile
    val updateProfileState : State<UpdateProfileState> get() = derivedStateOf { _updateProfileState }

    init {
        viewModelScope.launch {
            // add some delay for better transition
            delay(500)

            try{
                // get username from route
                val userName : String = savedStateHandle["username"] ?: ""

                // get user
                val getUser : UserModel = authRemoteUseCase.getUserUseCase(
                    userName = userName
                )

                // create update profile model
                val updateProfile = UpdateProfileModel(
                    userName = getUser.userName,
                    userFirstName = getUser.userFirstName,
                    userLastName = getUser.userLastName,
                    userPhoneNumber = getUser.userPhoneNumber
                )

                // update state into data state
                _initEntryState = UpdateProfileState.DataState(
                    data = updateProfile
                )
            } catch (e : Exception) {
                // create error message
                val errMsg : String = "Error Happen : ${e.message}, ${e.stackTrace}"

                // update state into error state
                _initEntryState = UpdateProfileState.ErrorState(
                    errMsg = errMsg,
                )
            }
        }
    }

    // create on event function
    fun onEvent(event : UpdateProfileEvent) {
        when(event) {
            is UpdateProfileEvent.OnUpdate -> {
                // set update profile state into loading state
                _updateProfileState = UpdateProfileState.LoadingState

                viewModelScope.launch {
                    // add delay for better transition
                    delay(500)

                    try{
                        // update  user profile
                        val getUser : UserModel = authRemoteUseCase.updateUserProfileUseCase(
                            userProfile = event.userProfile
                        )

                        // create update profile
                        val updateProfile = UpdateProfileModel(
                            userName = getUser.userName,
                            userFirstName = getUser.userFirstName,
                            userLastName = getUser.userLastName,
                            userPhoneNumber = getUser.userPhoneNumber
                        )

                        // update state into data state
                        _updateProfileState = UpdateProfileState.DataState(
                            data = updateProfile
                        )
                    } catch (e : Exception) {
                        // create error message
                        val errMsg : String = "Error happen : ${e.message}, ${e.stackTrace}"

                        // update state into error state
                        _updateProfileState = UpdateProfileState.ErrorState(
                            errMsg = errMsg,
                        )
                    }
                }
            }
        }
    }

    // create function to change update profile state
    fun changeUpdateProfileState(state : UpdateProfileState) {
        _updateProfileState = state
    }
}