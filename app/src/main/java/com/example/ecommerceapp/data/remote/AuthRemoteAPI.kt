package com.example.ecommerceapp.data.remote

import com.example.ecommerceapp.data.dto.ResponseDto
import com.example.ecommerceapp.domain.models.LoginUserRequestModel
import com.example.ecommerceapp.domain.models.LoginUserResponseModel
import com.example.ecommerceapp.domain.models.UpdateProfileModel
import com.example.ecommerceapp.domain.models.UserModel
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface AuthRemoteAPI {
    // create function for register
    @Multipart
    @POST("register-user")
    suspend fun registerUser(
        @Part("email") userEmail : RequestBody,
        @Part("password") userPassword : RequestBody,
        @Part("firstName") userFirstName : RequestBody,
        @Part("lastName") userLastName : RequestBody,
        @Part("phoneNumber") userPhoneNumber : RequestBody,
        @Part("username") userName : RequestBody,
        @Part image : MultipartBody.Part
    ) : ResponseDto<UserModel>

    // create function for login
    @POST("login-user")
    suspend fun loginUser(
        @Body loginUser : LoginUserRequestModel
    ) : ResponseDto<LoginUserResponseModel>

    // create function for get user profile
    @GET("get-profile/{username}")
    suspend fun getUserProfile(@Path("username") username : String) : ResponseDto<UserModel>

    // create function for update user profile
    @POST("update-profile")
    suspend fun updateUserProfile(@Body updateProfile : UpdateProfileModel) : ResponseDto<UserModel>
}