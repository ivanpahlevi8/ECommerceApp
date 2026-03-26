package com.example.ecommerceapp.presentation.profile_screen.component

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.component.shimmerEffect
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme

@Composable
fun ProfilePageShimmer() {
    // create local context
    val localContext = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = Dimension.MEDIUM_PADDING2
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(170.dp)
                .clip(
                    shape = CircleShape
                )
                .shimmerEffect()
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.LARGE_PADDING3 * 3,
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "First Name",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W600,
                    letterSpacing = 1.1.sp,
                    fontSize = 20.sp,
                ),
                color = colorResource(
                    id = R.color.text_title
                )
            )

            Box(
                modifier = Modifier
                    .height(35.dp)
                    .width(120.dp)
                    .shimmerEffect()
            )
        }

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING2
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Last Name",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W600,
                    letterSpacing = 1.1.sp,
                    fontSize = 20.sp,
                ),
                color = colorResource(
                    id = R.color.text_title
                )
            )

            Box(
                modifier = Modifier
                    .height(35.dp)
                    .width(120.dp)
                    .shimmerEffect()
            )
        }

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING2
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Username",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W600,
                    letterSpacing = 1.1.sp,
                    fontSize = 20.sp,
                ),
                color = colorResource(
                    id = R.color.text_title
                )
            )

            Box(
                modifier = Modifier
                    .height(35.dp)
                    .width(120.dp)
                    .shimmerEffect()
            )
        }

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING2
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Email",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W600,
                    letterSpacing = 1.1.sp,
                    fontSize = 20.sp,
                ),
                color = colorResource(
                    id = R.color.text_title
                )
            )

            Box(
                modifier = Modifier
                    .height(35.dp)
                    .width(120.dp)
                    .shimmerEffect()
            )
        }

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING3
                )
        )

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.average_end)
            ),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.padding(Dimension.SMALL_PADDING2)
        ) {
            Text(
                text = "UPDATE PROFILE",
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
fun ProfilePageShimmerPreview() {
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
            ProfilePageShimmer()
        }
    }
}