package com.example.ecommerceapp.presentation.update_profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.domain.models.UpdateProfileModel
import com.example.ecommerceapp.domain.models.UserModel
import com.example.ecommerceapp.presentation.update_profile.component.UpdateProfilePage
import com.example.ecommerceapp.presentation.update_profile.component.UpdateProfilePageShimmer

@Composable
fun UpdateProfileScreen(
    state: UpdateProfileState,
    updateState : UpdateProfileState,
    onEvent : (UpdateProfileEvent) -> Unit,
    changeUpdateState : (UpdateProfileState) -> Unit,
) {
    when(state) {
        is UpdateProfileState.DataState -> {
            // get data state
            val getData : UpdateProfileModel = state.data

            // show data state
            UpdateProfilePage(
                profileData = getData,
                onEvent = onEvent
            )
        }

        is UpdateProfileState.ErrorState -> {
            // get error message
            val errMsg : String = state.errMsg

            // show error page
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        Dimension.MEDIUM_PADDING1
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = errMsg,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W600,
                        letterSpacing = 1.1.sp,
                        fontSize = 16.sp,
                    ),
                    color = colorResource(
                        id = R.color.error_color,
                    )
                )
            }
        }

        is UpdateProfileState.LoadingState -> {
            // show loading page
            UpdateProfilePageShimmer()
        }

        is UpdateProfileState.IdleState -> {}
    }

    // watch state on update state
    when(updateState) {
        is UpdateProfileState.DataState -> {
            // get data
            val getData = updateState.data

            // show data dialog
            Dialog(
                onDismissRequest = {}
            ) {
                Surface(
                    color = colorResource(
                        id = R.color.excellent_end
                    ),
                    modifier = Modifier
                        .width(180.dp)
                        .height(
                            160.dp
                        )
                        .clip(
                            shape = MaterialTheme.shapes.medium
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Success update data for username : ${getData.userName}",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.W600,
                                fontSize = 16.sp,
                            ),
                            color = colorResource(
                                id = R.color.white,
                            )
                        )

                        Spacer(
                            modifier = Modifier
                                .height(
                                    Dimension.SMALL_PADDING2
                                )
                        )

                        Button(
                            onClick = {
                                changeUpdateState(
                                    UpdateProfileState.IdleState
                                )
                            },
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Text(
                                text = "OK"
                            )
                        }
                    }
                }
            }
        }
        is UpdateProfileState.ErrorState -> {
            val errMsg = updateState.errMsg

            // show error dialog
            Dialog(
                onDismissRequest = {}
            ) {
                Surface(
                    color = colorResource(
                        id = R.color.error_color
                    ),
                    modifier = Modifier
                        .width(180.dp)
                        .height(
                            160.dp
                        )
                        .clip(
                            shape = MaterialTheme.shapes.medium
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = errMsg,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.W600,
                                fontSize = 16.sp,
                            ),
                            color = colorResource(
                                id = R.color.white,
                            )
                        )

                        Spacer(
                            modifier = Modifier
                                .height(
                                    Dimension.SMALL_PADDING2
                                )
                        )

                        Button(
                            onClick = {
                                changeUpdateState(
                                    UpdateProfileState.IdleState
                                )
                            },
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Text(
                                text = "OK"
                            )
                        }
                    }
                }
            }
        }
        is UpdateProfileState.LoadingState -> {
            Dialog(
                onDismissRequest = {}
            ) {
                Surface(
                    color = colorResource(
                        id = R.color.card_background_color2
                    ),
                    modifier = Modifier
                        .width(160.dp)
                        .height(
                            160.dp
                        )
                        .clip(
                            shape = MaterialTheme.shapes.medium
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
        is UpdateProfileState.IdleState -> {}
    }
}