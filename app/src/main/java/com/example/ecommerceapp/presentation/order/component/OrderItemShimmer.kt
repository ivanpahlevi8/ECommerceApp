package com.example.ecommerceapp.presentation.order.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.component.shimmerEffect
import com.example.ecommerceapp.core.value.Dimension

@Composable
fun OrderItemShimmer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 4.dp,
                shape = MaterialTheme.shapes.medium
            )
            .clip(
                shape = MaterialTheme.shapes.medium
            )
            .background(
                color = colorResource(
                    id = R.color.card_background_color2
                )
            )
            .padding(
                vertical = Dimension.MEDIUM_PADDING1,
                horizontal = Dimension.MEDIUM_PADDING2
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            Box(
                modifier = Modifier
                    .height(
                        45.dp
                    )
                    .width(
                        120.dp
                    )
                    .shimmerEffect()
            )

            Spacer(
                modifier = Modifier
                    .height(
                        Dimension.MEDIUM_PADDING3
                    )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Order Status",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W600,
                        fontSize = 18.sp,
                    ),
                    color = colorResource(
                        id = R.color.text_title
                    )
                )

                Box(
                    modifier = Modifier
                        .height(
                            35.dp
                        )
                        .width(
                            100.dp
                        )
                        .shimmerEffect()
                )
            }

            Spacer(
                modifier = Modifier
                    .height(
                        Dimension.SMALL_PADDING2
                    )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Seller Info",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W600,
                        fontSize = 18.sp,
                    ),
                    color = colorResource(
                        id = R.color.text_title,
                    )
                )

                IconButton(
                    onClick = {
                    }
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.keyboard_arrow_down_ic
                        ),
                        contentDescription = "Arrow Down Ucon",
                        modifier = Modifier
                            .size(18.dp),
                        tint = colorResource(
                            id = R.color.text_title
                        )
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Product List",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W600,
                        fontSize = 18.sp,
                    ),
                    color = colorResource(
                        id = R.color.text_title,
                    )
                )

                IconButton(
                    onClick = {
                    }
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.keyboard_arrow_down_ic
                        ),
                        contentDescription = "Arrow Down Ucon",
                        modifier = Modifier
                            .size(18.dp),
                        tint = colorResource(
                            id = R.color.text_title
                        )
                    )
                }
            }
        }
    }
}