package com.example.ecommerceapp.presentation.cart.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.domain.models.UserModel
import com.example.ecommerceapp.domain.models.cart_models.CartDetailModel
import com.example.ecommerceapp.domain.models.cart_models.CartHeaderModel
import com.example.ecommerceapp.domain.models.cart_models.CartModel
import com.example.ecommerceapp.presentation.cart.CartEvent
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartPage(
    cart : CartModel?,
    isRefresh : Boolean,
    onRefresh : () -> Unit,
    onEvent : (CartEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                vertical = Dimension.SMALL_PADDING2,
                horizontal = Dimension.MEDIUM_PADDING1
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(cart == null) {
            Text(
                text = "Cart empty, add product",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W800,
                    fontSize = 20.sp
                ),
                color = colorResource(
                    id = R.color.text_title
                )
            )
        } else {
            CartHeaderItem(
                cartHeader = cart.cartHeader,
                onEvent = onEvent
            )

            Spacer(
                modifier = Modifier
                    .height(
                        Dimension.SMALL_PADDING2
                    )
            )

            PullToRefreshBox(
                isRefreshing = isRefresh,
                onRefresh = onRefresh,
            ) {
                CartDetailItemList(
                    cartDetailItems = cart.cartDetailList,
                    onEvent = onEvent
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CartPagePreview() {
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
            CartPage(
                onRefresh = {},
                isRefresh = false,
                onEvent = {},
                cart = CartModel(
                    cartHeader = CartHeaderModel(
                        cartHeaderId = "",
                        cartHeaderUserId = "",
                        cartHeaderRequesterUser = UserModel(
                            userFirstName = "",
                            userLastName = "",
                            userEmail = "",
                            userImage = "",
                            userName = "",
                            userPhoneNumber = "",
                            userId = ""
                        ),
                        cartHeaderProductAmount = 20,
                        cartHeaderProductCost = 16000000.0
                    ),
                    cartDetailList = listOf(
                        CartDetailModel(
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
                        CartDetailModel(
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
                        CartDetailModel(
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
                        CartDetailModel(
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
                        )
                    )
                )
            )
        }
    }
}