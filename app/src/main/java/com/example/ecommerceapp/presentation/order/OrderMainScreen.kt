package com.example.ecommerceapp.presentation.order

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.value.Dimension

@Composable
fun OrderMainScreen(
    state: OrderState,
    requestState : OrderState,
    onEvent: (OrderEvent) -> Unit,
    orderEvent: OrderEventState,
    onRefreshOrder : () -> Unit,
    onRefreshOrderRequest : () -> Unit,
    isOrderRefresh : Boolean,
    isOrderRequestRefresh : Boolean,
) {
    // create state
    var showOrder by remember { mutableStateOf(true) }
    var showOrderRequest by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(
                        50.dp
                    )
                    .background(
                        color = colorResource(
                            id = if(showOrder) R.color.button_detail_background else R.color.card_background_color2
                        )
                    )
                    .clickable {
                        showOrder = true
                        showOrderRequest = false
                    }
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "ORDER",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.W800,
                            fontSize = 18.sp
                        ),
                        color = colorResource(
                            id = R.color.text_title
                        )
                    )
                }
            }
            Box (
                modifier = Modifier
                    .weight(1f)
                    .height(
                        50.dp
                    )
                    .background(
                        color = colorResource(
                            id = if(showOrderRequest) R.color.button_detail_background else R.color.card_background_color2
                        )
                    )
                    .clickable {
                        showOrder = false
                        showOrderRequest = true
                    }
            ){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "ORDER REQUEST",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.W800,
                            fontSize = 18.sp
                        ),
                        color = colorResource(
                            id = R.color.text_title
                        )
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING1
                )
        )

        AnimatedVisibility(
            showOrder
        ) {
            OrderScreen(
                state = state,
                isRefresh = isOrderRefresh,
                onRefresh = onRefreshOrder
            )
        }

        AnimatedVisibility(
            showOrderRequest
        ) {
            OrderRequestScreen(
                requestState,
                onEvent = onEvent,
                isRefresh = isOrderRequestRefresh,
                onRefresh = onRefreshOrderRequest
            )
        }

        when(orderEvent){
            is OrderEventState.DataState -> {
                // get data
                val getData = orderEvent.data

                // show data
                Dialog(
                    onDismissRequest = {},
                ) {
                    Surface(
                        modifier = Modifier
                            .width(
                                200.dp
                            ),
                        color = colorResource(
                            id = R.color.excellent_end
                        ),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = Dimension.SMALL_PADDING2
                                ),
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
                                text = getData,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.W600,
                                    fontSize = 16.sp
                                ),
                                textAlign = TextAlign.Justify,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                    }
                }
            }
            is OrderEventState.ErrorState -> {
                // get error
                val getErr = orderEvent.errMsg

                // show error
                Dialog(
                    onDismissRequest = {},
                ) {
                    Surface(
                        modifier = Modifier
                            .width(
                                200.dp
                            ),
                        color = colorResource(
                            id = R.color.excellent_end
                        ),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = Dimension.SMALL_PADDING2
                                ),
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
                                text = getErr,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.W600,
                                    fontSize = 16.sp
                                ),
                                textAlign = TextAlign.Justify,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                        }
                    }
                }
            }
            is OrderEventState.LoadingState -> {
                Dialog(
                    onDismissRequest = {},
                ) {
                    Surface(
                        modifier = Modifier
                            .size(
                                160.dp
                            ),
                        color = colorResource(
                            id = R.color.excellent_end
                        ),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = Dimension.SMALL_PADDING2
                                ),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
            is OrderEventState.IdleState -> {}
        }
    }
}