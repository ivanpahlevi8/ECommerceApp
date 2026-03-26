package com.example.ecommerceapp.presentation.update_profile.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.component.shimmerEffect
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.presentation.auth_screen.component.InputItem
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme

@Composable
fun UpdateProfilePageShimmer(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
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

        Box(
            modifier = Modifier
                .height(
                    50.dp
                )
                .fillMaxWidth()
                .shimmerEffect()
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING1
                )
        )

        Box(
            modifier = Modifier
                .height(
                    50.dp
                )
                .fillMaxWidth()
                .shimmerEffect()
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING1
                )
        )

        Box(
            modifier = Modifier
                .height(
                    50.dp
                )
                .fillMaxWidth()
                .shimmerEffect()
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING1
                )
        )

        Box(
            modifier = Modifier
                .height(
                    50.dp
                )
                .fillMaxWidth()
                .shimmerEffect()
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING3
                )
        )

        Button(
            onClick = {
                // update
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
fun UpdateProfilePageShimmerPreview() {
    ECommerceAppTheme {
        Box(
            modifier = Modifier
                .padding(
                    Dimension.MEDIUM_PADDING2
                )
                .background(
                    color = MaterialTheme.colorScheme.background
                )
        ) {
            UpdateProfilePageShimmer()
        }
    }
}