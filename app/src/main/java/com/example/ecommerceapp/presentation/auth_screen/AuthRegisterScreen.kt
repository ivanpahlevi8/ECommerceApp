package com.example.ecommerceapp.presentation.auth_screen

import android.content.Context
import android.content.res.Configuration
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.domain.models.RegisterUserRequestModel
import com.example.ecommerceapp.domain.models.UserModel
import com.example.ecommerceapp.presentation.auth_screen.component.InputItem
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

@Composable
fun AuthRegisterScreen(
    onEvent : (AuthScreenEvent) -> Unit,
    authState : AuthScreenState,
    setState : (AuthScreenState) -> Unit,
){
    // create local context
    val localContext = LocalContext.current

    // create initial value for input
    var inputEmail by remember { mutableStateOf("") }
    var inputUsername by remember { mutableStateOf("") }
    var inputPassword by remember { mutableStateOf("") }
    var inputFirstName by remember { mutableStateOf("") }
    var inputLastName by remember { mutableStateOf("") }
    var inputPhoneNumber by remember { mutableStateOf("") }
    var urlString by remember { mutableStateOf("") }
    var multipart by remember { mutableStateOf<MultipartBody.Part?>(null) }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        //When the user has selected a photo, its URI is returned here
        if(uri != null) {
            urlString = uri.path.toString()
            multipart = uriToMultipart(localContext, uri)
        }
    }

    when(authState) {
        is AuthScreenState.DataState<*> -> {
            // get user model
            val getUserModel : UserModel = authState.userModel as UserModel

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
                            text = "Success register with username ${getUserModel.userName}",
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
        is AuthScreenState.ErrorState -> {
            // get error message
            val errMsg : String = authState.errMsg

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
        is AuthScreenState.IdleState -> {
        }
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
            text = "Register As A New User",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.W800,
                letterSpacing = 1.1.sp,
                fontSize = 22.sp,
            ),
            color = colorResource(
                id = R.color.text_title,
            )
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING3
                )
        )

        InputItem(
            value = inputEmail,
            onChange = {
                newValue : String -> inputEmail = newValue
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
            value = inputUsername,
            onChange = {
                    newValue : String -> inputUsername = newValue
            },
            labelText = "Username"
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.SMALL_PADDING1
                )
        )

        InputItem(
            value = inputPassword,
            onChange = {
                    newValue : String -> inputPassword = newValue
            },
            isPassword = true,
            labelText = "Password"
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.SMALL_PADDING1
                )
        )

        InputItem(
            value = inputFirstName,
            onChange = {
                    newValue : String -> inputFirstName = newValue
            },
            labelText = "First Name"
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.SMALL_PADDING1
                )
        )

        InputItem(
            value = inputLastName,
            onChange = {
                    newValue : String -> inputLastName = newValue
            },
            labelText = "Last Name"
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.SMALL_PADDING1
                )
        )

        InputItem(
            value = inputPhoneNumber,
            onChange = {
                    newValue : String -> inputPhoneNumber = newValue
            },
            labelText = "Phone Number",
            keyboardType = KeyboardType.Number,
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.SMALL_PADDING1
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            InputItem(
                modifier = Modifier
                    .weight(1f),
                value = urlString,
                onChange = {
                        newValue : String -> urlString = newValue
                },
                labelText = "Image",
                readonly = true,
            )
            Spacer(
                modifier = Modifier
                    .width(
                        Dimension.SMALL_PADDING1
                    )
            )

            Button(
                shape = RoundedCornerShape(size = 8.dp),
                onClick = {
                    //On button press, launch the photo picker
                    launcher.launch(
                        PickVisualMediaRequest(
                        mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                    )
                    )
                }
            ) {
                Text("Select Photo")
            }
        }

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING2
                )
        )

        Button(
            onClick = {
                if(multipart != null) {
                    onEvent(
                        AuthScreenEvent.OnRegister(
                            registerModel = RegisterUserRequestModel(
                                userEmail = inputEmail,
                                userPassword = inputPassword,
                                userFirstName = inputFirstName,
                                userLastName = inputLastName,
                                userPhoneNumber = inputPhoneNumber,
                                userImageFile = multipart!!,
                                username = inputUsername
                            )
                        )
                    )
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.excellent_start)
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

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AuthRegisterScreenPreview(){
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
            AuthRegisterScreen(
                onEvent = {},
                authState = AuthScreenState.IdleState,
                setState = {}
            )
        }
    }
}

fun uriToMultipart(context: Context, uri: Uri): MultipartBody.Part? {
    // 1. Get the actual file name from the Uri
    val fileName = context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
        val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        cursor.moveToFirst()
        cursor.getString(nameIndex)
    } ?: "upload_${System.currentTimeMillis()}.jpg" // Fallback name if query fails

    // 2. Create the temporary file in cache using the real name
    val file = File(context.cacheDir, fileName)

    val inputStream = context.contentResolver.openInputStream(uri)

    // 3. Copy stream to file
    inputStream?.use { input ->
        file.outputStream().use { output ->
            input.copyTo(output)
        }
    }

    // 4. Create the RequestBody and MultipartBody.Part
    val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())

    // The first "image" is the key your API expects
    return MultipartBody.Part.createFormData("imageFile", file.name, requestFile)
}