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
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.value.Dimension

@Composable
fun FinishedOrderMainScreen(
    state: OrderState,
    requestState : OrderState,
) {
    // create state
    var showFinishedOrder by remember { mutableStateOf(true) }
    var showFinishedOrderRequest by remember { mutableStateOf(false) }

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
                            id = if(showFinishedOrder) R.color.button_detail_background else R.color.card_background_color2
                        )
                    )
                    .clickable {
                        showFinishedOrder = true
                        showFinishedOrderRequest = false
                    }
            ) {
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
            Box (
                modifier = Modifier
                    .weight(1f)
                    .height(
                        50.dp
                    )
                    .background(
                        color = colorResource(
                            id = if(showFinishedOrderRequest) R.color.button_detail_background else R.color.card_background_color2
                        )
                    )
                    .clickable {
                        showFinishedOrder = false
                        showFinishedOrderRequest = true
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
            showFinishedOrder
        ) {
            FinishedOrderScreen(
                state = state,
            )
        }

        AnimatedVisibility(
            showFinishedOrderRequest
        ) {
            FinishedOrderRequestScreen(
                requestState,
            )
        }
    }
}