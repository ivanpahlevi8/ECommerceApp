package com.example.ecommerceapp.presentation.auth_screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.domain.models.LoginUserRequestModel
import com.example.ecommerceapp.domain.models.LoginUserResponseModel
import com.example.ecommerceapp.presentation.auth_screen.component.InputItem
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme

@Composable
fun LoginUserScreen(
    onRegister : () -> Unit,
    onEvent : (AuthScreenEvent) -> Unit,
    authState : AuthScreenState,
    setState : (AuthScreenState) -> Unit,
){
    // create login variable
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

    // check on auth state
    when(authState) {
        is AuthScreenState.DataState<*> -> {
            // get login response
            val userLoginResponse = authState.userModel as LoginUserResponseModel

            // show dialog
            Dialog(
                onDismissRequest = {
                    setState(
                        AuthScreenState.IdleState
                    )
                },
                properties = DialogProperties(
                    dismissOnBackPress = false,
                    dismissOnClickOutside = false
                )
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .height(200.dp)
                        .width(250.dp)
                        .background(
                            color = colorResource(
                                id = R.color.excellent_end
                            ),
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Success Login ${userLoginResponse.userModel.userName}",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.W800,
                                letterSpacing = 1.1.sp,
                                fontSize = 18.sp
                            ),
                            color = colorResource(
                                id = R.color.white
                            )
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(
                            shape = RoundedCornerShape(size = 8.dp),
                            onClick = {
                                setState(
                                    AuthScreenState.IdleState
                                )
                            }
                        ) {
                            Text("Ok")
                        }
                    }
                }
            }
        }
        is AuthScreenState.ErrorState -> {
            // get error message
            val errMsg = authState.errMsg

            // show dialog
            Dialog(
                onDismissRequest = {
                    setState(
                        AuthScreenState.IdleState
                    )
                },
                properties = DialogProperties(
                    dismissOnBackPress = false,
                    dismissOnClickOutside = false
                )
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .height(200.dp)
                        .width(250.dp)
                        .background(
                            color = colorResource(
                                id = R.color.error_color
                            ),
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = errMsg,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.W800,
                                letterSpacing = 1.1.sp,
                                fontSize = 18.sp
                            ),
                            color = colorResource(
                                id = R.color.white
                            )
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(
                            shape = RoundedCornerShape(size = 8.dp),
                            onClick = {
                                setState(
                                    AuthScreenState.IdleState
                                )
                            }
                        ) {
                            Text("Ok")
                        }
                    }
                }
            }
        }
        is AuthScreenState.LoadingState -> {
            Dialog(
                onDismissRequest = { /* Usually empty to prevent closing during critical tasks */ },
                properties = DialogProperties(
                    dismissOnBackPress = false,
                    dismissOnClickOutside = false
                )
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(120.dp)
                        .background(
                            color = MaterialTheme.colorScheme.surface,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(
                            color = MaterialTheme.colorScheme.primary,
                            strokeWidth = 4.dp
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Loading...",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
        is AuthScreenState.IdleState -> {}
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = Dimension.MEDIUM_PADDING2
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Welcome To Krem's Commerce",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.W800,
                letterSpacing = 1.1.sp,
                fontSize = 20.sp,
            ),
            color = colorResource(
                id = R.color.text_title
            )
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING1
                )
        )

        Text(
            text = "Login With Your Existing Credential",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.W600,
                fontSize = 18.sp,
            ),
            textAlign = TextAlign.Center,
            color = colorResource(
                id = R.color.text_title
            )
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING3
                )
        )

        InputItem(
            value = emailInput,
            onChange = {
                newValue : String -> emailInput = newValue
            },
            labelText = "Email"
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.SMALL_PADDING1
                )
        )

        InputItem(
            value = passwordInput,
            onChange = {
                    newValue : String -> passwordInput = newValue
            },
            labelText = "Password",
            isPassword = true
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING1
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = {
                    // create user login request
                    val loginUserRequest : LoginUserRequestModel = LoginUserRequestModel(
                        loginEmail = emailInput,
                        loginPassword = passwordInput
                    )

                    // login
                    onEvent(
                        AuthScreenEvent.OnLogin(
                            loginUser = loginUserRequest
                        )
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.excellent_start)
                ),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(Dimension.SMALL_PADDING2)
            ) {
                Text(
                    text = "LOGIN",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp
                    ),
                    color = colorResource(id = R.color.white)
                )
            }

            Spacer(
                modifier = Modifier
                    .width(
                        Dimension.SMALL_PADDING1
                    )
            )

            Button(
                onClick = {
                    onRegister()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.average_end)
                ),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(Dimension.SMALL_PADDING2)
            ) {
                Text(
                    text = "REGISTER",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp
                    ),
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LoginUserScreenPreview() {
    ECommerceAppTheme {
        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.background
                )
                .padding(
                    Dimension.MEDIUM_PADDING3
                )
        ) {
            LoginUserScreen(
                onRegister = {},
                onEvent = {},
                authState = AuthScreenState.IdleState,
                setState = {}
            )
        }
    }
}