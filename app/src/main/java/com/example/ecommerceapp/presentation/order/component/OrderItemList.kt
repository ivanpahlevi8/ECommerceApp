package com.example.ecommerceapp.presentation.order.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ecommerceapp.domain.models.order_models.OrderModel

@Composable
fun OrderItemList(
    orderItems : List<OrderModel>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        items(
            count = orderItems.size
        ) {
            index : Int ->
            // get data
            val getData = orderItems[index]

            // show data
            OrderItem(
                order = getData
            )
        }
    }
}