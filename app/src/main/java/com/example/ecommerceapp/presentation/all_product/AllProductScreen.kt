package com.example.ecommerceapp.presentation.all_product

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.presentation.all_product.component.ProductItemPage
import com.example.ecommerceapp.presentation.all_product.component.ProductItemPageShimmer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllProductScreen(
    state: AllProductState,
    refreshState: Boolean,
    onRefresh: () -> Unit,
    onDetail : (String) -> Unit,
    onEvent : (AllProductEvent) -> Unit,
    addCartProductState: CartProductState,
    updateCartProductState : (CartProductState) -> Unit,
) {
    PullToRefreshBox(
        isRefreshing = refreshState,
        onRefresh = onRefresh,
        // state = rememberPullToRefreshState() // Note: PullToRefreshBox handles state internally, usually you don't need to pass this unless customizing
    ) {
        when (state) {
            is AllProductState.DataState -> {
                val getData = state.data
                if (getData.isEmpty()) {
                    // FIX: Added verticalScroll so the pull gesture works on empty screens
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "No Records To Be Shown", /* ... your styles ... */)
                    }
                } else {
                    ProductItemPage(
                        productList = getData,
                        onDetail = onDetail,
                        onEvent = onEvent,
                    )
                }
            }
            is AllProductState.ErrorState -> {
                // FIX: Added verticalScroll so you can refresh to try again after an error
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = state.errMsg, color = colorResource(id = R.color.error_color))
                }
            }
            is AllProductState.LoadingState -> {
                // Ensure your Shimmer is inside a scrollable container or
                // simply show the loading shimmer (pull-to-refresh is usually hidden during initial load anyway)
                ProductItemPageShimmer()
            }
        }

        when(addCartProductState) {
            is CartProductState.DataState -> {
                // show success state
                Dialog(
                    onDismissRequest = {},
                ) {
                    Surface(
                        color = colorResource(
                            id = R.color.excellent_end
                        ),
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .width(
                                200.dp
                            )
                            .padding(
                                horizontal = Dimension.SMALL_PADDING2,
                                vertical = Dimension.SMALL_PADDING1
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "SUCCESS!!!",
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
                                text = "Success adding product to your cart, check cart for more information",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.W600,
                                    fontSize = 15.sp
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

                            Button(
                                onClick = {
                                    updateCartProductState(
                                        CartProductState.IdleState
                                    )
                                },
                            ) {
                                Text(
                                    text = "OK",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.W800,
                                        fontSize = 14.sp
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
            is CartProductState.ErrorState -> {
                val errMsg = addCartProductState.errMsg

                Dialog(
                    onDismissRequest = {},
                ) {
                    Surface(
                        color = colorResource(
                            id = R.color.error_color
                        ),
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .width(
                                200.dp
                            )
                            .padding(
                                horizontal = Dimension.SMALL_PADDING2,
                                vertical = Dimension.SMALL_PADDING1
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "SUCCESS!!!",
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
                                text = errMsg,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.W600,
                                    fontSize = 15.sp
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

                            Button(
                                onClick = {
                                    updateCartProductState(
                                        CartProductState.IdleState
                                    )
                                },
                            ) {
                                Text(
                                    text = "OK",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.W800,
                                        fontSize = 14.sp
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
            is CartProductState.LoadingState -> {
                Dialog(
                    onDismissRequest = {},
                ) {
                    Surface(
                        color = colorResource(
                            id = R.color.excellent_end
                        ),
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .size(
                                150.dp
                            )
                            .padding(
                                horizontal = Dimension.SMALL_PADDING2,
                                vertical = Dimension.SMALL_PADDING1
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
            is CartProductState.IdleState -> {}
        }
    }
}