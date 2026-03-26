package com.example.ecommerceapp.presentation.auth_screen

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapp.core.value.Constants
import com.example.ecommerceapp.domain.models.LoginUserRequestModel
import com.example.ecommerceapp.domain.models.LoginUserResponseModel
import com.example.ecommerceapp.domain.models.RegisterUserRequestModel
import com.example.ecommerceapp.domain.models.UserModel
import com.example.ecommerceapp.domain.usecase.auth_remote_usecase.AuthRemoteUseCase
import com.example.ecommerceapp.domain.usecase.local_user_manager_usecase.LocalUserManagerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class AuthScreenViewModel @Inject constructor(
    private val authRemoteUseCase: AuthRemoteUseCase,
    private val localUserManagerUseCase: LocalUserManagerUseCase,
    private val sharedPreferences: SharedPreferences
) : ViewModel() {
    // create state for register auth
    private var _registerAuthState by mutableStateOf<AuthScreenState>(AuthScreenState.IdleState)

    // exposed state for register auth
    val registerAuthState : State<AuthScreenState> get() = derivedStateOf { _registerAuthState }

    // create state for login auth
    private var _loginAuthState by mutableStateOf<AuthScreenState>(AuthScreenState.IdleState)

    // exposed state for login auth
    val loginAuthState : State<AuthScreenState> get() = derivedStateOf { _loginAuthState }

    // create on event function
    fun onEvent(event : AuthScreenEvent) {
        when(event) {
            is AuthScreenEvent.OnRegister -> {
                // set state into loading state
                _registerAuthState = AuthScreenState.LoadingState

                // get register model
                val registerModel : RegisterUserRequestModel = event.registerModel

                viewModelScope.launch {
                    // add delay for better transition
                    delay(500)

                    try{
                        // register user
                        val getUser : UserModel = authRemoteUseCase.registerUserUseCase(
                            registerUser = registerModel
                        )

                        // update state into data state
                        _registerAuthState = AuthScreenState.DataState(
                            userModel = getUser
                        )
                    } catch (e : Exception) {
                        // create error message
                        val errMsg : String = "Error Happen : ${e.message}, ${e.stackTrace}"

                        // update state into error state
                        _registerAuthState = AuthScreenState.ErrorState(
                            errMsg = errMsg
                        )
                    }
                }
            }
            is AuthScreenEvent.OnLogin -> {
                // set login state into loading state
                _loginAuthState = AuthScreenState.LoadingState

                // get login request
                val loginRequest : LoginUserRequestModel = event.loginUser

                viewModelScope.launch {
                    try{
                        // add delay for better transition
                        delay(600)

                        // do login
                        val response : LoginUserResponseModel = authRemoteUseCase.loginUserUseCase(
                            loginUser = loginRequest
                        )

                        // set login local
                        localUserManagerUseCase.setUserLoginUseCase()

                        // set data
                        sharedPreferences.edit().putString(Constants.USER_NAME, response.userModel.userName).apply()
                        sharedPreferences.edit().putString(Constants.EMAIL, response.userModel.userEmail).apply()
                        sharedPreferences.edit().putString(Constants.USER_IMAGE, "${Constants.BASE_URL}/users${response.userModel.userImage}").apply()
                        sharedPreferences.edit().putString(Constants.JWT_TOKE, response.userToken).apply()
                        sharedPreferences.edit().putString(Constants.USER_ID, response.userModel.userId).apply()

                        Log.d("CHECK", "Check on login user id response : ${response.userModel.userId}")

                        // update state into data state
                        _loginAuthState = AuthScreenState.DataState(
                            response
                        )
                    } catch (e : Exception) {
                        // create error message
                        val errMsg : String = "Error happen : ${e.message}, ${e.stackTrace}"

                        // update state into error state
                        _loginAuthState = AuthScreenState.ErrorState(
                            errMsg = errMsg,
                        )
                    }
                }
            }
        }
    }

    // create function to set state
    fun setState(state : AuthScreenState) {
        _registerAuthState = state
    }

    // create function to set state gor login state
    fun setLoginState(state : AuthScreenState) {
        _loginAuthState = state
    }
}