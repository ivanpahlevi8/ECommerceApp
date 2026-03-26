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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
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
import com.example.ecommerceapp.domain.models.order_models.OrderModel
import com.example.ecommerceapp.presentation.order.component.OrderItemList
import com.example.ecommerceapp.presentation.order.component.OrderItemListShimmer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(
    state : OrderState,
    isRefresh : Boolean,
    onRefresh : () -> Unit,
) {
    PullToRefreshBox(
        isRefreshing = isRefresh,
        onRefresh = onRefresh,
    ) {
        when(state) {
            is OrderState.DataState -> {
                // get data
                val getData : List<OrderModel> = state.data

                // show data
                OrderItemList(
                    orderItems = getData
                )
            }
            is OrderState.ErrorState -> {
                // get error message
                val errMsg = state.errMsg

                // show error message
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(
                            state = rememberScrollState()
                        )
                        .padding(
                            horizontal = Dimension.MEDIUM_PADDING1
                        ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = errMsg,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.W600,
                            fontSize = 16.sp,
                        ),
                        color = colorResource(
                            id = R.color.error_color
                        )
                    )
                }
            }
            is OrderState.LoadingState -> {
                OrderItemListShimmer()
            }
        }
    }
}