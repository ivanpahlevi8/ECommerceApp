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
import com.example.ecommerceapp.domain.models.cart_models.CartDetailRequestModel
import com.example.ecommerceapp.presentation.all_product.AllProductEvent
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme
import java.text.NumberFormat
import java.util.Locale

@Composable
fun ProductItem(
    product : ProductModel,
    onDetail : (String) -> Unit,
    onEvent : (AllProductEvent) -> Unit,
) {
    // create local context
    val localContext = LocalContext.current

    // get local currency
    val localCurr = NumberFormat.getCurrencyInstance(Locale.US)

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
            Text(
                text = product.productName,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W600,
                    letterSpacing = 1.1.sp,
                    fontSize = 18.sp
                ),
                color = colorResource(
                    id = R.color.text_title
                )
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
                    .shadow(
                        elevation = 2.dp,
                        shape = MaterialTheme.shapes.medium
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
                    ).data("${Constants.BASE_URL}${product.productImage}").build(),
                    contentDescription = "Product Image",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop,
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

                Text(
                    text = localCurr.format(product.productPrice),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp
                    ),
                    color = colorResource(
                        id = R.color.text_medium,
                    )
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
                        // create cart detail request
                        val cartDetailRequest = CartDetailRequestModel(
                            cartDetailId = 0,
                            cartHeaderId = 0,
                            productId = product.productId.toInt(),
                            userOwnerId = product.productUserId,
                            userRequesterId = "",
                        )

                        onEvent(
                            AllProductEvent.AddCartEvent(
                                cartDetailRequestModel = cartDetailRequest,
                            )
                        )
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
                        onDetail(
                            product.productId
                        )
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
fun ProductItemPreview() {
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
            ProductItem(
                product = ProductModel(
                    productId = "",
                    productName = "Ayam Bakar",
                    productDescription = "ajkfsjudfns",
                    productImage = "",
                    productPrice = 12000.0,
                    categoryId = "",
                    productUserId = ""
                ),
                onDetail = {},
                onEvent = {}
            )
        }
    }
}