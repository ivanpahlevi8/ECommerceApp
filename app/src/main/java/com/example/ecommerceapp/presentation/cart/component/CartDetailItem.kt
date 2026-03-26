package com.example.ecommerceapp.presentation.cart.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import com.example.ecommerceapp.domain.models.UserModel
import com.example.ecommerceapp.domain.models.cart_models.CartDetailModel
import com.example.ecommerceapp.presentation.cart.CartEvent
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme
import java.text.NumberFormat
import java.util.Locale

@Composable
fun CartDetailItem(
    cartDetail : CartDetailModel,
    onEvent : (CartEvent) -> Unit,
) {
    // create local state
    val localContext = LocalContext.current

    // get local currency
    val localCurr = NumberFormat.getCurrencyInstance(Locale.US)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = Dimension.MEDIUM_PADDING1,
                horizontal = Dimension.MEDIUM_PADDING2
            )
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
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                modifier = Modifier
                    .size(85.dp)
                    .clip(
                        shape = CircleShape
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
                    ).data("${Constants.BASE_URL}${cartDetail.cartDetailProduct.productImage}").build(),
                    contentDescription = "Cart Detail Product Image",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
            }

            Spacer(
                modifier = Modifier
                    .width(
                        Dimension.SMALL_PADDING2
                    )
            )

            Column(
                modifier = Modifier
                    .weight(1f),
            ) {
                Text(
                    text = cartDetail.cartDetailProduct.productName,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
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
                            .size(18.dp),
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

                    Text(
                        text = localCurr.format(
                            cartDetail.cartDetailProduct.productPrice
                        ),
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                        ),
                        color = colorResource(
                            id = R.color.text_title
                        )
                    )
                }
            }

            Button(
                onClick = {
                    onEvent(
                        CartEvent.OnDeleteCartDetail(
                            cartDetailId = cartDetail.cartDetailId
                        )
                    )
                },
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
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
                )
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.delete_forever_ic
                    ),
                    contentDescription = "Delete Icon",
                    modifier = Modifier
                        .size(18.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CartDetailItemPreview() {
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
            CartDetailItem(
                cartDetail = CartDetailModel(
                    cartDetailId = 1,
                    cartHeaderId = 1,
                    cartDetailProductId = 1,
                    cartDetailProduct = ProductModel(
                        productId = "",
                        productName = "Iphone 16",
                        productDescription = "",
                        productImage = "",
                        productPrice = 16000000.0,
                        categoryId = "",
                        productUserId = ""
                    ),
                    cartDetailUserOwnerId = "",
                    cartDetailUserOwner = UserModel(
                        userFirstName = "",
                        userLastName = "",
                        userEmail = "",
                        userImage = "",
                        userName = "",
                        userPhoneNumber = "",
                        userId = ""
                    ),
                    cartDetailUserRequesterId = "",
                    cartDetailRequesterOwner = UserModel(
                        userFirstName = "",
                        userLastName = "",
                        userEmail = "",
                        userImage = "",
                        userName = "",
                        userPhoneNumber = "",
                        userId = ""
                    ),
                ),
                onEvent = {}
            )
        }
    }
}