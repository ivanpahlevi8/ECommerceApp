package com.example.ecommerceapp.presentation.cart.component

import android.content.res.Configuration
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.component.shimmerEffect
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme

@Composable
fun CartHeaderItemShimmer() {
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
                ),
                shape = MaterialTheme.shapes.medium
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Cart Summary",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W800,
                    fontSize = 20.sp,
                ),
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

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.add_shopping_cart_ic
                    ),
                    contentDescription = "Shopping cart icon",
                    modifier = Modifier
                        .size(22.dp),
                    tint = colorResource(
                        id = R.color.text_title,
                    )
                )

                Spacer(
                    modifier = Modifier
                        .width(
                            Dimension.SMALL_PADDING2
                        )
                )

                Box(
                    modifier = Modifier
                        .height(
                            40.dp
                        )
                        .width(
                            90.dp
                        )
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
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.money_ic
                    ),
                    contentDescription = "Money icon",
                    modifier = Modifier
                        .size(22.dp),
                    tint = colorResource(
                        id = R.color.text_title,
                    )
                )

                Spacer(
                    modifier = Modifier
                        .width(
                            Dimension.SMALL_PADDING2
                        )
                )

                Box(
                    modifier = Modifier
                        .height(
                            30.dp
                        )
                        .width(
                            120.dp
                        )
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
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {},
                    colors = ButtonColors(
                        containerColor = colorResource(
                            id = R.color.error_color
                        ),
                        contentColor = colorResource(
                            id = R.color.white
                        ),
                        disabledContainerColor = colorResource(
                            id = R.color.error_color
                        ),
                        disabledContentColor = colorResource(
                            id = R.color.white
                        ),
                    ),
                ) {
                    Text(
                        text = "Delete Cart",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = colorResource(
                            id = R.color.white
                        )
                    )
                }

                Spacer(
                    modifier = Modifier
                        .width(
                            Dimension.SMALL_PADDING2
                        )
                )

                Button(
                    onClick = {},
                    colors = ButtonColors(
                        containerColor = colorResource(
                            id = R.color.average_end
                        ),
                        contentColor = colorResource(
                            id = R.color.white
                        ),
                        disabledContainerColor = colorResource(
                            id = R.color.average_end
                        ),
                        disabledContentColor = colorResource(
                            id = R.color.white
                        ),
                    ),
                ) {
                    Text(
                        text = "Clear Cart",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = colorResource(
                            id = R.color.white
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CartHeaderItemShimmerPreview() {
    ECommerceAppTheme {
        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.background
                )
                .padding(
                    Dimension.MEDIUM_PADDING1
                )
        ) {
            CartHeaderItemShimmer()
        }
    }
}