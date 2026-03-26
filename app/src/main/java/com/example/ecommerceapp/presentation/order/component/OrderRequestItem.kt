package com.example.ecommerceapp.presentation.order.component

import android.content.res.Configuration
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.value.Constants
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.domain.models.UserModel
import com.example.ecommerceapp.domain.models.order_models.OrderModel
import com.example.ecommerceapp.presentation.order.OrderEvent
import com.example.ecommerceapp.presentation.order.OrderEventState
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme

@Composable
fun OrderRequestItem(
    order : OrderModel,
    onEvent : (OrderEvent) -> Unit,
) {
    // create local context
    val localContext = LocalContext.current

    // create state for show seller info
    var showSellerInfo by remember { mutableStateOf(false) }

    // create state for show product
    var showProduct by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Order Id : ${order.orderId}",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W600,
                        fontSize = 20.sp
                    ),
                    color = colorResource(
                        id = R.color.text_title
                    ),
                    textAlign = TextAlign.Center,
                )

                Spacer(
                    modifier = Modifier
                        .height(
                            Dimension.MEDIUM_PADDING1
                        )
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Buyer Info",
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
                            showSellerInfo = !showSellerInfo
                        }
                    ) {
                        Icon(
                            painter = painterResource(
                                id = if(!showSellerInfo) R.drawable.keyboard_arrow_down_ic else R.drawable.keyboard_arrow_up_ic
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

                AnimatedVisibility(
                    visible = showSellerInfo
                ) {
                    Box(
                        modifier = Modifier
                            .padding(
                                horizontal = Dimension.SMALL_PADDING1
                            )
                            .clip(
                                shape = MaterialTheme.shapes.medium
                            )
                            .background(
                                color = colorResource(
                                    id = R.color.card_background_color3
                                )
                            )
                            .padding(
                                vertical = Dimension.MEDIUM_PADDING1,
                                horizontal = Dimension.MEDIUM_PADDING2
                            )
                    ) {
                        Row {
                            Box(
                                modifier = Modifier
                                    .size(70.dp)
                                    .clip(
                                        shape = CircleShape
                                    )
                                    .background(
                                        color = colorResource(
                                            id = R.color.text_title,
                                        )
                                    )
                            ) {
                                AsyncImage(
                                    model = ImageRequest.Builder(
                                        localContext
                                    ).data("${Constants.BASE_URL}/users${order.orderUserOwner.userImage}").build(),
                                    contentDescription = "User Image",
                                )
                            }

                            Spacer(
                                modifier = Modifier
                                    .width(
                                        Dimension.SMALL_PADDING2
                                    )
                            )

                            Column {
                                Text(
                                    text = "${order.orderUserRequester.userLastName}, ${order.orderUserRequester.userFirstName}",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.W600,
                                    ),
                                    color = colorResource(
                                        id = R.color.text_title
                                    )
                                )

                                Text(
                                    text = order.orderUserRequester.userEmail,
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.W600,
                                    ),
                                    color = colorResource(
                                        id = R.color.text_title
                                    )
                                )

                                Text(
                                    text = order.orderUserRequester.userPhoneNumber,
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.W600,
                                    ),
                                    color = colorResource(
                                        id = R.color.text_title
                                    )
                                )
                            }
                        }
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
                            showProduct = !showProduct
                        }
                    ) {
                        Icon(
                            painter = painterResource(
                                id = if(!showProduct) R.drawable.keyboard_arrow_down_ic else R.drawable.keyboard_arrow_up_ic
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
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            // approve button
                            onEvent(
                                OrderEvent.OnApprove(
                                    orderId = order.orderId
                                )
                            )
                        },
                        colors = ButtonColors(
                            containerColor = colorResource(
                                id = R.color.excellent_end,
                            ),
                            contentColor = colorResource(
                                id = R.color.white
                            ),
                            disabledContainerColor = colorResource(
                                id = R.color.excellent_end,
                            ),
                            disabledContentColor = colorResource(
                                id = R.color.white
                            ),
                        )
                    ) {
                        Text(
                            text = "APPROVE",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.W800,
                                fontSize = 16.sp
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
                        onClick = {
                            // cancel button
                            onEvent(
                                OrderEvent.OnCancel(
                                    orderId = order.orderId
                                )
                            )
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
                        )
                    ) {
                        Text(
                            text = "CANCEL",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.W800,
                                fontSize = 16.sp
                            ),
                            color = colorResource(
                                id = R.color.white
                            )
                        )
                    }
                }
            }
        }
        OrderProductItemList(
            itemList = order.orderAllProduct,
            showProduct = showProduct,
        )
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OrderRequestItemPreview() {
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
            OrderRequestItem(
                onEvent = {},
                order = OrderModel(
                    orderId = 0,
                    orderUserRequesterId = "",
                    orderUserOwnerId = "",
                    orderUserOwner = UserModel(
                        userFirstName = "Ivan",
                        userLastName = "Pahlevi",
                        userEmail = "ivan.indirsya@gmail.com",
                        userName = "ivanpahlevi8",
                        userImage = "",
                        userPhoneNumber = "458653423",
                        userId = ""
                    ),
                    orderUserRequester = UserModel(
                        userFirstName = "Ivan",
                        userLastName = "Pahlevi",
                        userEmail = "ivan.indirsya@gmail.com",
                        userName = "ivanpahlevi8",
                        userImage = "",
                        userPhoneNumber = "458653423",
                        userId = ""
                    ),
                    orderProductId = listOf(),
                    orderAllProduct = listOf(),
                    orderStatus = "APPROVED"
                ),
            )
        }
    }
}