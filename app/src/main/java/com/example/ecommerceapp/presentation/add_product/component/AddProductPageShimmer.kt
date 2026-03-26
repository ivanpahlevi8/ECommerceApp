package com.example.ecommerceapp.presentation.add_product.component

import android.content.res.Configuration
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.component.shimmerEffect
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.domain.models.InsertProductModel
import com.example.ecommerceapp.presentation.add_product.AddProductEvent
import com.example.ecommerceapp.presentation.auth_screen.component.InputItem
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme

@Composable
fun AddProductPageShimmer() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Upload Your Product",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.W800,
                letterSpacing = 1.1.sp,
                fontSize = 20.sp,
            ),
            color = colorResource(
                id = R.color.text_title
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
                .padding(
                    horizontal = Dimension.MEDIUM_PADDING3
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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    45.dp
                )
                .padding(
                    horizontal = Dimension.MEDIUM_PADDING3
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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    45.dp
                )
                .padding(
                    horizontal = Dimension.MEDIUM_PADDING3
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
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(
                        45.dp
                    )
                    .padding(
                        horizontal = Dimension.MEDIUM_PADDING3
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
                onClick = {},
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Category")
            }
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
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(
                        45.dp
                    )
                    .padding(
                        horizontal = Dimension.MEDIUM_PADDING3
                    )
                    .clip(
                        shape = MaterialTheme.shapes.medium
                    )
                    .shimmerEffect()
            )

            Spacer(
                modifier = Modifier
                    .width(
                        Dimension.MEDIUM_PADDING1
                    )
            )

            Button(
                shape = RoundedCornerShape(size = 8.dp),
                onClick = {
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
                text = "INSERT",
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

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AddProductPageShimmerPreview() {
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
            AddProductPageShimmer()
        }
    }
}