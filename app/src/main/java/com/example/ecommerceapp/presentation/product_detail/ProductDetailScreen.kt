package com.example.ecommerceapp.presentation.product_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.domain.models.CategoryModel
import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.presentation.product_detail.component.ProductDetailPage
import com.example.ecommerceapp.presentation.product_detail.component.ProductDetailPageShimmer

@Composable
fun ProductDetailScreen(
    state : ProductDetailState
) {
    when(state) {
        is ProductDetailState.DataState -> {
            // get data
            val getProduct : ProductModel = state.product
            val getCategory : CategoryModel = state.category

            // show data page
            ProductDetailPage(
                product = getProduct,
                categoryModel = getCategory
            )
        }
        is ProductDetailState.ErrorState -> {
            val errMsg : String = state.errMsg

            // show error page
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = Dimension.MEDIUM_PADDING1
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
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
        is ProductDetailState.LoadingState -> {
            ProductDetailPageShimmer()
        }
    }
}