package com.example.ecommerceapp.presentation.order.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ecommerceapp.domain.models.order_models.OrderModel
import com.example.ecommerceapp.presentation.order.OrderEvent

@Composable
fun OrderRequestItemList(
    itemList : List<OrderModel>,
    onEvent : (OrderEvent) -> Unit,
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        items(
            count = itemList.size
        ) {
                index : Int ->
            // get data
            val getData = itemList[index]

            // show data
            OrderRequestItem(
                order = getData,
                onEvent = onEvent,
            )
        }
    }
}