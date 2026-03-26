package com.example.ecommerceapp.presentation.update_profile.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.domain.models.UpdateProfileModel
import com.example.ecommerceapp.presentation.auth_screen.component.InputItem
import com.example.ecommerceapp.presentation.update_profile.UpdateProfileEvent
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme

@Composable
fun UpdateProfilePage(
    profileData : UpdateProfileModel,
    onEvent : (UpdateProfileEvent) -> Unit,
) {
    // create input variable
    var userNameInput by remember { mutableStateOf(profileData.userName) }
    var firstNameInput by remember { mutableStateOf(profileData.userFirstName) }
    var lastNameInput by remember { mutableStateOf(profileData.userLastName) }
    var phoneNumberInput by remember { mutableStateOf(profileData.userPhoneNumber) }

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
            text = "Update Profile",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.W800,
                letterSpacing = 1.1.sp,
                fontSize = 20.sp
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
            value = userNameInput,
            onChange = {
                    newValue : String -> userNameInput = newValue
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
            value = firstNameInput,
            onChange = {
                    newValue : String -> firstNameInput = newValue
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
            value = lastNameInput,
            onChange = {
                    newValue : String -> lastNameInput = newValue
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
            value = phoneNumberInput,
            onChange = {
                    newValue : String -> phoneNumberInput = newValue
            },
            labelText = "Phone Number"
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING3
                )
        )

        Button(
            onClick = {
                // create profile
                val newUpdateProfile = UpdateProfileModel(
                    userName = userNameInput,
                    userFirstName = firstNameInput,
                    userLastName = lastNameInput,
                    userPhoneNumber = phoneNumberInput
                )

                // update
                onEvent(
                    UpdateProfileEvent.OnUpdate(
                        newUpdateProfile
                    )
                )
            },
            shape = MaterialTheme.shapes.medium,
            colors = ButtonColors(
                containerColor = colorResource(
                    id = R.color.average_end
                ),
                contentColor = colorResource(
                    id = R.color.white,
                ),
                disabledContentColor = colorResource(
                    id = R.color.average_end
                ),
                disabledContainerColor = colorResource(
                    id = R.color.average_end
                ),
            )
        ) {
            Text(
                "UPDATE"
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun UpdateProfilePagePreview() {
    ECommerceAppTheme {
        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.background
                )
                .padding(
                    Dimension.MEDIUM_PADDING2
                )
        ) {
            UpdateProfilePage(
                profileData = UpdateProfileModel(
                    userName = "ivanpahlevi8",
                    userFirstName = "Ivan",
                    userLastName = "Indirsyah",
                    userPhoneNumber = "438538650"
                ),
                onEvent = {}
            )
        }
    }
}