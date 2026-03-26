package com.example.ecommerceapp.presentation.own_products_update

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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.domain.models.CategoryModel
import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.presentation.own_products_update.component.OwnProductsUpdatePage
import com.example.ecommerceapp.presentation.own_products_update.component.OwnProductsUpdatePageShimmer

@Composable
fun OwnProductsUpdateScreen(
    initialState : OwnProductsUpdateState,
    updateState : OwnProductsUpdateState,
    onEvent : (OwnProductsUpdateEvent) -> Unit,
    changeUpdateState : (OwnProductsUpdateState) -> Unit,
){
    var productData by remember { mutableStateOf<ProductModel?>(null) }
    var categoryListData by remember { mutableStateOf<List<CategoryModel>>(listOf()) }

    when(initialState) {
        is OwnProductsUpdateState.DataState -> {
            // get each data
            productData = initialState.data
            categoryListData = initialState.categoryList

            // show data page
            OwnProductsUpdatePage(
                product = productData!!,
                categoryList = categoryListData,
                onEvent = onEvent,
            )
        }
        is OwnProductsUpdateState.ErrorState -> {
            // get err msg
            val errMsg : String = initialState.errMsg

            // show error message
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = Dimension.SMALL_PADDING2
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = errMsg,
                    style = MaterialTheme.typography.titleMedium,
                    color = colorResource(
                        id = R.color.error_color,
                    )
                )
            }
        }
        is OwnProductsUpdateState.LoadingState -> {
            OwnProductsUpdatePageShimmer()
        }
        is OwnProductsUpdateState.IdleState -> {
            // show data page
            OwnProductsUpdatePage(
                product = productData!!,
                categoryList = categoryListData,
                onEvent = onEvent,
            )
        }
    }

    // check for update state
    when(updateState) {
        is OwnProductsUpdateState.DataState -> {
            // get data
            val getData = updateState.data

            // show data dialog
            Dialog(
                onDismissRequest = {}
            ) {
                Surface(
                    modifier = Modifier
                        .width(200.dp)
                        .padding(
                            Dimension.SMALL_PADDING2
                        )
                        .clip(
                            shape = MaterialTheme.shapes.medium
                        )
                        .background(
                            color = colorResource(
                                id = R.color.excellent_end
                            )
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            "Success update ${getData.productName}",
                            style = MaterialTheme.typography.titleMedium,
                            color = colorResource(
                                id = R.color.white
                            )
                        )

                        Spacer(
                            modifier = Modifier
                                .height(
                                    Dimension.MEDIUM_PADDING1
                                )
                        )

                        Button(
                            onClick = {
                                changeUpdateState(
                                    OwnProductsUpdateState.IdleState
                                )
                            },
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Text(
                                text = "OK",
                            )
                        }
                    }
                }
            }
        }
        is OwnProductsUpdateState.ErrorState -> {
            // get error msg
            val errMsg = updateState.errMsg

            Dialog(
                onDismissRequest = {}
            ) {
                Surface(
                    modifier = Modifier
                        .width(200.dp)
                        .padding(
                            Dimension.SMALL_PADDING2
                        )
                        .clip(
                            shape = MaterialTheme.shapes.medium
                        )
                        .background(
                            color = colorResource(
                                id = R.color.error_color
                            )
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            errMsg,
                            style = MaterialTheme.typography.titleMedium,
                            color = colorResource(
                                id = R.color.white
                            )
                        )

                        Spacer(
                            modifier = Modifier
                                .height(
                                    Dimension.MEDIUM_PADDING1
                                )
                        )

                        Button(
                            onClick = {
                                changeUpdateState(
                                    OwnProductsUpdateState.IdleState
                                )
                            },
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Text(
                                text = "OK",
                            )
                        }
                    }
                }
            }
        }
        is OwnProductsUpdateState.LoadingState -> {
            Dialog(
                onDismissRequest = {}
            ) {
                Surface(
                    modifier = Modifier
                        .size(160.dp)
                        .clip(
                            shape = MaterialTheme.shapes.medium
                        )
                        .background(
                            color = colorResource(
                                id = R.color.excellent_end
                            )
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
        is OwnProductsUpdateState.IdleState -> {}
    }
}