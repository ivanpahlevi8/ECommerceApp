package com.example.ecommerceapp.presentation.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.domain.models.cart_models.CartModel
import com.example.ecommerceapp.presentation.cart.component.CartPage
import com.example.ecommerceapp.presentation.cart.component.CartPageShimmer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    state : CartState,
    isRefresh : Boolean,
    onRefresh : () -> Unit,
    onEvent : (CartEvent) -> Unit,
    cartEventState : CartState,
    updateCartEventState : (CartState) -> Unit,
) {
    var dataState : CartModel? by remember { mutableStateOf<CartModel?>(null) }
    when(state) {
        is CartState.DataState<*> -> {
            // get data state
            val getData = state.data

            // set data state
            dataState = getData as CartModel

            // show data page
            CartPage(
                cart = getData,
                isRefresh = isRefresh,
                onRefresh = onRefresh,
                onEvent = onEvent,
            )
        }
        is CartState.ErrorState -> {
            // get error message
            val errMsg = state.errMsg

            // show error page
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = errMsg,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W800
                    ),
                    color = colorResource(
                        id = R.color.white
                    )
                )
            }
        }
        is CartState.LoadingState -> {
            CartPageShimmer()
        }
        is CartState.IdleState -> {
            // show data page
            CartPage(
                cart = dataState,
                isRefresh = isRefresh,
                onRefresh = onRefresh,
                onEvent = onEvent,
            )
        }
    }

    // watch cart event state
    when(cartEventState) {
        is CartState.DataState<*> -> {
            // get data
            val getData = cartEventState.data as String

            // show dialog
            Dialog(
                onDismissRequest = {},
            ) {
                Surface(
                    color = colorResource(
                        id = R.color.excellent_end
                    ),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .width(200.dp)
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
                            text = "SUCCESS",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.W800,
                                fontSize = 18.sp
                            ),
                            color = colorResource(
                                id = R.color.white
                            )
                        )

                        Spacer(
                            modifier = Modifier
                                .height(
                                    Dimension.SMALL_PADDING2
                                )
                        )

                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = getData,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.W800,
                                fontSize = 16.sp
                            ),
                            color = colorResource(
                                id = R.color.white
                            ),
                            textAlign = TextAlign.Justify,
                        )

                        Spacer(
                            modifier = Modifier
                                .height(
                                    Dimension.SMALL_PADDING2
                                )
                        )

                        Button(
                            onClick = {
                                updateCartEventState(CartState.IdleState)
                            },
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Text(
                                text = "OK",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.W800
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
        is CartState.ErrorState -> {
            // get error message
            val errMsg = cartEventState.errMsg

            // show dialog
            Dialog(
                onDismissRequest = {},
            ) {
                Surface(
                    color = colorResource(
                        id = R.color.error_color
                    ),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .width(200.dp)
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
                            text = "ERROR",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.W800,
                                fontSize = 18.sp
                            ),
                            color = colorResource(
                                id = R.color.white
                            )
                        )

                        Spacer(
                            modifier = Modifier
                                .height(
                                    Dimension.SMALL_PADDING2
                                )
                        )

                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = errMsg,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.W800,
                                fontSize = 16.sp
                            ),
                            color = colorResource(
                                id = R.color.white
                            ),
                            textAlign = TextAlign.Justify,
                        )

                        Spacer(
                            modifier = Modifier
                                .height(
                                    Dimension.SMALL_PADDING2
                                )
                        )

                        Button(
                            onClick = {
                                updateCartEventState(CartState.IdleState)
                            },
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Text(
                                text = "OK",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.W800
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
        is CartState.LoadingState -> {
            // show dialog
            Dialog(
                onDismissRequest = {},
            ) {
                Surface(
                    color = colorResource(
                        id = R.color.card_background_color2
                    ),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .size(160.dp)
                        .padding(
                            vertical = Dimension.SMALL_PADDING2,
                            horizontal = Dimension.MEDIUM_PADDING1
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
        is CartState.IdleState -> {}
    }
}