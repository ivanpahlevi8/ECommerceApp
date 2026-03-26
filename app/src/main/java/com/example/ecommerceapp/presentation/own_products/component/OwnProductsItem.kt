package com.example.ecommerceapp.presentation.own_products.component

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.value.Constants
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme
import java.text.NumberFormat
import java.util.Locale

@Composable
fun OwnProductsItem(
    productItem : ProductModel,
    onDelete : (ProductModel) -> Unit,
    onUpdate : (ProductModel) -> Unit,
) {
    // create local context
    val localContext = LocalContext.current

    // get local currency
    val localCurr = NumberFormat.getCurrencyInstance(Locale.US)

    Box(
        modifier = Modifier
            .padding(
                Dimension.SMALL_PADDING2
            )
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
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = productItem.productName,
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
                    .size(180.dp)
                    .shadow(
                        elevation = 2.dp,
                    )
                    .clip(
                        shape = MaterialTheme.shapes.medium
                    )
                    .background(
                        color = colorResource(
                            id = R.color.text_title
                        )
                    )
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(
                        localContext
                    ).data("${Constants.BASE_URL}${productItem.productImage}").build(),
                    contentDescription = "Product Image Placeholder",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
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
                        id = R.drawable.money_ic,
                    ),
                    contentDescription = "Money Icon",
                    modifier = Modifier
                        .size(20.dp),
                    tint = colorResource(
                        id = R.color.text_title
                    )
                )

                Spacer(
                    modifier = Modifier
                        .width(
                            Dimension.SMALL_PADDING2
                        )
                )

                Text(
                    text = localCurr.format(productItem.productPrice),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W600,
                        fontSize = 18.sp,
                    ),
                    color = colorResource(
                        id = R.color.text_title
                    )
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
                horizontalArrangement = Arrangement.Center,
            ) {
                Button(
                    onClick = {
                        // delete button
                        onDelete(productItem)
                    },
                    colors = ButtonColors(
                        containerColor = colorResource(
                            id = R.color.error_color,
                        ),
                        contentColor = colorResource(
                            id = R.color.white
                        ),
                        disabledContainerColor = colorResource(
                            id = R.color.error_color,
                        ),
                        disabledContentColor = colorResource(
                            id = R.color.white
                        ),
                    ),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.delete_forever_ic
                        ),
                        contentDescription = "Delete Icon",
                        modifier = Modifier.size(20.dp),
                        tint = colorResource(
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
                    onClick = {
                        // update button
                        onUpdate(productItem)
                    },
                    colors = ButtonColors(
                        containerColor = colorResource(
                            id = R.color.average_end,
                        ),
                        contentColor = colorResource(
                            id = R.color.white
                        ),
                        disabledContainerColor = colorResource(
                            id = R.color.average_end,
                        ),
                        disabledContentColor = colorResource(
                            id = R.color.white
                        ),
                    ),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.edit_ic
                        ),
                        contentDescription = "Delete Icon",
                        modifier = Modifier.size(20.dp),
                        tint = colorResource(
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
fun OwnProductsItemPreview() {
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
            OwnProductsItem(
                productItem = ProductModel(
                    productId = "",
                    productName = "Ferrari SF19 Stradale",
                    productDescription = "",
                    productImage = "",
                    productPrice = 1000000000000.0,
                    categoryId = "",
                    productUserId = ""
                ),
                onDelete = {},
                onUpdate = {}
            )
        }
    }
}