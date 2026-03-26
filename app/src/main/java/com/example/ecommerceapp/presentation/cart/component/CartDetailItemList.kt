package com.example.ecommerceapp.presentation.cart.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.domain.models.UserModel
import com.example.ecommerceapp.domain.models.cart_models.CartDetailModel
import com.example.ecommerceapp.presentation.cart.CartEvent
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme

@Composable
fun CartDetailItemList(
    cartDetailItems : List<CartDetailModel>,
    onEvent : (CartEvent) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            count = cartDetailItems.size
        ) {
            index : Int ->
            // get data
            val getData = cartDetailItems[index]

            // show data
            CartDetailItem(
                cartDetail = getData,
                onEvent = onEvent
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CartDetailItemListPreview() {
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
            CartDetailItemList(
                onEvent = {},
                cartDetailItems = listOf(
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
        }
    }
}