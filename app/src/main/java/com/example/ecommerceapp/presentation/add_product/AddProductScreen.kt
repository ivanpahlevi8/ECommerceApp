@file:Suppress("UNCHECKED_CAST")

package com.example.ecommerceapp.presentation.add_product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.example.ecommerceapp.domain.models.CategoryModel
import com.example.ecommerceapp.presentation.add_product.component.AddProductPage
import com.example.ecommerceapp.presentation.add_product.component.AddProductPageShimmer
import com.example.ecommerceapp.presentation.update_profile.UpdateProfileState

@Composable
fun AddProductScreen(
    initState : InitAddProductState,
    addProductState : AddProductState,
    onEvent : (AddProductEvent) -> Unit,
    updateAddProductState : (AddProductState) -> Unit,
) {
    when(initState) {
        is InitAddProductState.DataState -> {
            // get data
            val getData : List<CategoryModel> = initState.data

            // show data page
            AddProductPage(
                categoryList = getData,
                onEvent = onEvent,
            )
        }
        is InitAddProductState.ErrorState -> {
            // get error message
            val errMsg : String = initState.errMsg

            // show error page
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = errMsg,
                    style = MaterialTheme.typography.titleMedium,
                    color = colorResource(
                        id = R.color.error_color
                    )
                )
            }
        }
        is InitAddProductState.LoadingState -> {
            AddProductPageShimmer()
        }
    }

    when(addProductState) {
        is AddProductState.DataState -> {
            // get data
            val getData = addProductState.data

            Dialog(
                onDismissRequest = {}
            ) {
                Surface(
                    color = colorResource(
                        id = R.color.excellent_end
                    ),
                    modifier = Modifier
                        .width(180.dp)
                        .height(
                            160.dp
                        )
                        .clip(
                            shape = MaterialTheme.shapes.medium
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Success insert product : ${getData.productName}",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.W600,
                                fontSize = 16.sp,
                            ),
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
                                updateAddProductState(
                                    AddProductState.IdleState
                                )
                            },
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Text(
                                text = "OK"
                            )
                        }
                    }
                }
            }
        }
        is AddProductState.ErrorState -> {
            val errMsg = addProductState.errMsg

            Dialog(
                onDismissRequest = {}
            ) {
                Surface(
                    color = colorResource(
                        id = R.color.error_color
                    ),
                    modifier = Modifier
                        .width(180.dp)
                        .height(
                            160.dp
                        )
                        .clip(
                            shape = MaterialTheme.shapes.medium
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = errMsg,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.W600,
                                fontSize = 16.sp,
                            ),
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
                                updateAddProductState(
                                    AddProductState.IdleState
                                )
                            },
                            shape = MaterialTheme.shapes.medium
                        ) {
                            Text(
                                text = "OK"
                            )
                        }
                    }
                }
            }
        }
        is AddProductState.LoadingState -> {
            Dialog(
                onDismissRequest = {}
            ) {
                Surface(
                    color = colorResource(
                        id = R.color.excellent_end
                    ),
                    modifier = Modifier
                        .width(160.dp)
                        .height(
                            160.dp
                        )
                        .clip(
                            shape = MaterialTheme.shapes.medium
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
        is AddProductState.IdleState -> {}
    }
}