package com.example.ecommerceapp.presentation.own_products_update.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.component.shimmerEffect
import com.example.ecommerceapp.core.value.Dimension

@Composable
fun OwnProductsUpdatePageShimmer() {
    Column(
        modifier = Modifier
            .padding(
                horizontal = Dimension.MEDIUM_PADDING2
            )
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Update Product",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.W800,
                fontSize = 20.sp,
                letterSpacing = 1.1.sp
            ),
            color = colorResource(
                id = R.color.text_title,
            )
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING2
                )
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    45.dp
                )
                .clip(
                    shape = MaterialTheme.shapes.medium
                )
                .shimmerEffect()
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.SMALL_PADDING1
                )
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    45.dp
                )
                .clip(
                    shape = MaterialTheme.shapes.medium
                )
                .shimmerEffect()
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.SMALL_PADDING1
                )
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    45.dp
                )
                .clip(
                    shape = MaterialTheme.shapes.medium
                )
                .shimmerEffect()
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
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(
                        45.dp
                    )
                    .clip(
                        shape = MaterialTheme.shapes.medium
                    )
                    .shimmerEffect()
            )

            Spacer(
                modifier = Modifier
                    .width(
                        Dimension.SMALL_PADDING2
                    )
            )

            Button(
                onClick = {  },
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Category")
            }
        }

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
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(
                        45.dp
                    )
                    .clip(
                        shape = MaterialTheme.shapes.medium
                    )
                    .shimmerEffect()
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
                }
            ) {
                Text("Select")
            }
        }

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING3
                )
        )

        Button(
            onClick = {
            },
            shape = MaterialTheme.shapes.medium,
            colors = ButtonColors(
                containerColor = colorResource(
                    id = R.color.excellent_end
                ),
                contentColor = colorResource(
                    id = R.color.white
                ),
                disabledContainerColor = colorResource(
                    id = R.color.excellent_end
                ),
                disabledContentColor = colorResource(
                    id = R.color.white
                ),
            )
        ) {
            Text(
                text = "UPDATE",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W600,
                    letterSpacing = 1.1.sp,
                    fontSize = 18.sp,
                ),
                color = colorResource(
                    id = R.color.white
                )
            )
        }
    }
}