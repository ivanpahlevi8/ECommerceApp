package com.example.ecommerceapp.presentation.all_product.component

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
fun ProductItemShimmer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                Dimension.SMALL_PADDING2
            )
            .shadow(
                elevation = 4.dp,
                shape = MaterialTheme.shapes.medium
            )
            .clip(
                shape = MaterialTheme.shapes.medium,
            )
            .background(
                color = colorResource(
                    id = R.color.card_background_color2
                )
            )
            .padding(
                vertical = Dimension.SMALL_PADDING2,
                horizontal = Dimension.MEDIUM_PADDING1
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .height(
                        40.dp
                    )
                    .width(
                        120.dp
                    )
                    .shimmerEffect()
            )

            Spacer(
                modifier = Modifier
                    .height(
                        Dimension.SMALL_PADDING2
                    )
            )

            Box(
                modifier = Modifier
                    .size(
                        180.dp
                    )
                    .clip(
                        shape = MaterialTheme.shapes.medium
                    )
                    .shimmerEffect()
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
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.money_ic
                    ),
                    contentDescription = "Money Icon",
                    tint = colorResource(
                        id = R.color.text_title
                    ),
                    modifier = Modifier
                        .size(18.dp)
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
                        .width(150.dp)
                        .shimmerEffect()
                )
            }

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
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        // cart action
                    },
                    colors = ButtonColors(
                        containerColor = colorResource(
                            id = R.color.excellent_end
                        ),
                        contentColor = colorResource(
                            id = R.color.white
                        ),
                        disabledContentColor = colorResource(
                            id = R.color.excellent_end
                        ),
                        disabledContainerColor = colorResource(
                            id = R.color.excellent_end
                        ),
                    ),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.add_shopping_cart_ic
                        ),
                        contentDescription = "Shopping Cart Icon",
                        tint = colorResource(
                            id = R.color.white,
                        )
                    )
                }

                Spacer(
                    modifier = Modifier
                        .width(
                            Dimension.MEDIUM_PADDING1
                        )
                )

                Button(
                    onClick = {
                        // detail action
                    },
                    colors = ButtonColors(
                        containerColor = colorResource(
                            id = R.color.average_end
                        ),
                        contentColor = colorResource(
                            id = R.color.white
                        ),
                        disabledContentColor = colorResource(
                            id = R.color.average_end
                        ),
                        disabledContainerColor = colorResource(
                            id = R.color.average_end
                        ),
                    ),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.details_ic
                        ),
                        contentDescription = "Detail Icon",
                        tint = colorResource(
                            id = R.color.white,
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
fun ProductItemShimmerPreview() {
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
            ProductItemShimmer()
        }
    }
}