package com.example.ecommerceapp.presentation.profile_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ecommerceapp.R
import com.example.ecommerceapp.presentation.profile_screen.component.ProfilePage
import com.example.ecommerceapp.presentation.profile_screen.component.ProfilePageShimmer

@Composable
fun ProfileScreen(
    state: ProfileScreenState,
    onUpdate : (String) -> Unit,
) {
    when(state) {
        is ProfileScreenState.DataState -> {
            // get data
            val getData = state.data

            // show data
            ProfilePage(
                userProfile = getData,
                onUpdate = onUpdate
            )
        }
        is ProfileScreenState.ErrorState -> {
            // get error message
            val errMsg = state.errMsg

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    errMsg,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W600,
                        letterSpacing = 1.1.sp,
                        fontSize = 18.sp
                    ),
                    color = colorResource(
                        id = R.color.error_color,
                    )
                )
            }
        }
        is ProfileScreenState.LoadingState -> {
            ProfilePageShimmer()
        }
    }
}