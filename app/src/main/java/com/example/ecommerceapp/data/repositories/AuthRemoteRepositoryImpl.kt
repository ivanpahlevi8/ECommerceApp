package com.example.ecommerceapp.data.repositories

import android.util.Log
import androidx.compose.ui.platform.LocalContext
import com.example.ecommerceapp.data.dto.ResponseDto
import com.example.ecommerceapp.data.remote.AuthRemoteAPI
import com.example.ecommerceapp.domain.models.LoginUserRequestModel
import com.example.ecommerceapp.domain.models.LoginUserResponseModel
import com.example.ecommerceapp.domain.models.RegisterUserRequestModel
import com.example.ecommerceapp.domain.models.UpdateProfileModel
import com.example.ecommerceapp.domain.models.UserModel
import com.example.ecommerceapp.domain.repositories.AuthRemoteRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.HttpException

class AuthRemoteRepositoryImpl(
    private val authRemoteAPI: AuthRemoteAPI,
) : AuthRemoteRepository {
    override suspend fun registerUser(registerRequest: RegisterUserRequestModel) : UserModel {
        try{
            // register user
            val response : ResponseDto<UserModel> = authRemoteAPI.registerUser(
                userEmail = registerRequest.userEmail.toRequestBody("text/plain".toMediaTypeOrNull()),
                userPassword = registerRequest.userPassword.toRequestBody("text/plain".toMediaTypeOrNull()),
                userFirstName = registerRequest.userFirstName.toRequestBody("text/plain".toMediaTypeOrNull()),
                userLastName = registerRequest.userLastName.toRequestBody("text/plain".toMediaTypeOrNull()),
                userPhoneNumber = registerRequest.userPhoneNumber.toRequestBody("text/plain".toMediaTypeOrNull()),
                userName = registerRequest.username.toRequestBody("text/plain".toMediaTypeOrNull()),
                image = registerRequest.userImageFile
            )

            // check for response
            if(!response.responseIsSuccess) {
                // throw exception
                throw Exception(response.responseMessage)
            }

            // return user data
            return response.responseResult
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            Log.e("CHECK", "SERVER ERROR DETAIL: $errorBody")
            throw Exception(errorBody ?: e.message())
        } catch (e: Exception) {
            Log.e("CHECK", "GENERAL ERROR: ${e.message}")
            throw e
        }
    }

    override suspend fun loginUser(loginUser: LoginUserRequestModel): LoginUserResponseModel {
        try{
            // login user
            val response : ResponseDto<LoginUserResponseModel> = authRemoteAPI.loginUser(
                loginUser = loginUser
            )

            // check response
            if(!response.responseIsSuccess) {
                Log.e("CHECK", response.responseMessage)
                throw Exception(response.responseMessage)
            }

            return response.responseResult
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            Log.e("CHECK", "SERVER ERROR DETAIL: $errorBody")
            throw Exception(errorBody ?: e.message())
        } catch (e: Exception) {
            Log.e("CHECK", "GENERAL ERROR: ${e.message}")
            throw e
        }
    }

    override suspend fun getUserProfile(userName: String): UserModel {
        // get user profile
        try{
            val response : ResponseDto<UserModel> = authRemoteAPI.getUserProfile(
                username = userName
            )

            // check on response
            if(!response.responseIsSuccess) {
                Log.e("Check", response.responseMessage)
                throw Exception(response.responseMessage)
            }

            return response.responseResult
        } catch (e : Exception) {
            throw (e)
        }
    }

    override suspend fun updateUserProfile(userProfile: UpdateProfileModel): UserModel {
        // update user profile
        val response : ResponseDto<UserModel> = authRemoteAPI.updateUserProfile(
            updateProfile = userProfile,
        )

        // check for response
        if(!response.responseIsSuccess) {
            throw Exception(response.responseMessage)
        }

        return response.responseResult
    }
}