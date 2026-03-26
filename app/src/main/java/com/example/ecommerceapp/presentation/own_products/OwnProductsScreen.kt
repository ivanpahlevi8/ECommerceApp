package com.example.ecommerceapp.presentation.own_products

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.presentation.own_products.component.OwnProductsPage
import com.example.ecommerceapp.presentation.own_products.component.OwnProductsPageShimmer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OwnProductsScreen(
    state: OwnProductsState,
    deleteProductState : OwnProductsEventState,
    updateDeleteProductState : (OwnProductsEventState) -> Unit,
    onDelete : (ProductModel) -> Unit,
    onUpdate : (ProductModel) -> Unit,
    refreshState : Boolean,
    onRefresh : () -> Unit,
) {
    PullToRefreshBox(
        isRefreshing = refreshState,
        onRefresh = onRefresh,
    ) {
        when(state) {
            is OwnProductsState.DataState -> {
                // get data state
                val getData : List<ProductModel> = state.data

                // show data page
                OwnProductsPage(
                    productList = getData,
                    onDelete = onDelete,
                    onUpdate = onUpdate,
                )
            }
            is OwnProductsState.ErrorState -> {
                // get error message
                val errMsg : String = state.errMsg

                // show error
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(
                            state = rememberScrollState()
                        )
                        .padding(
                            Dimension.SMALL_PADDING2
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
            is OwnProductsState.LoadingState -> {
                OwnProductsPageShimmer()
            }
        }
    }

    when(deleteProductState) {
        is OwnProductsEventState.DataState -> {
            // get data
            val getData : ProductModel = deleteProductState.data

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
                        .width(
                            200.dp
                        )
                        .padding(
                            vertical = Dimension.SMALL_PADDING1,
                            horizontal = Dimension.SMALL_PADDING2
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Success delete ${getData.productName}",
                            style = MaterialTheme.typography.labelMedium,
                            color = colorResource(
                                id = R.color.white,
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
                                updateDeleteProductState(
                                    OwnProductsEventState.IdleState
                                )
                            },
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Text(
                                text = "OK",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.W800
                                ),
                                color = colorResource(
                                    id = R.color.text_title
                                )
                            )
                        }
                    }
                }
            }
        }
        is OwnProductsEventState.ErrorState -> {
            // get error message
            val errMsg : String = deleteProductState.errMsg

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
                            vertical = Dimension.SMALL_PADDING1,
                            horizontal = Dimension.SMALL_PADDING2
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = errMsg,
                            style = MaterialTheme.typography.labelMedium,
                            color = colorResource(
                                id = R.color.white,
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
                                updateDeleteProductState(
                                    OwnProductsEventState.IdleState
                                )
                            },
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Text(
                                text = "OK",
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.W800
                                ),
                                color = colorResource(
                                    id = R.color.text_title
                                )
                            )
                        }
                    }
                }
            }
        }
        is OwnProductsEventState.LoadingState -> {
            Dialog(
                onDismissRequest = {},
            ) {
                Surface(
                    color = colorResource(
                        id = R.color.card_background_color2
                    ),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .size(
                            160.dp
                        )
                        .padding(
                            vertical = Dimension.SMALL_PADDING1,
                            horizontal = Dimension.SMALL_PADDING2
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
        is OwnProductsEventState.IdleState -> {}
    }
}