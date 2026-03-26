package com.example.ecommerceapp.presentation.all_product.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.presentation.all_product.AllProductEvent
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme

@Composable
fun ProductItemPage(
    productList : List<ProductModel>,
    onDetail : (String) -> Unit,
    onEvent : (AllProductEvent) -> Unit,
){
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize(),
        columns = GridCells.Fixed(2)
    ) {
        items(
            count = productList.size
        ) {
            index ->
            // get item
            val getItem : ProductModel = productList[index]

            // show item
            ProductItem(
                product = getItem,
                onDetail = onDetail,
                onEvent = onEvent
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProductItemPagePreview() {
    ECommerceAppTheme {
        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.background
                )
                .padding(
                    Dimension.MEDIUM_PADDING2
                )
        ) {
            ProductItemPage(
                productList = listOf(
                    ProductModel(
                        productId = "",
                        productName = "Ayam Bakar",
                        productDescription = "ajkfsjudfns",
                        productImage = "",
                        productPrice = 12000.0,
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "Ayam Bakar",
                        productDescription = "ajkfsjudfns",
                        productImage = "",
                        productPrice = 12000.0,
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "Ayam Bakar",
                        productDescription = "ajkfsjudfns",
                        productImage = "",
                        productPrice = 12000.0,
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "Ayam Bakar",
                        productDescription = "ajkfsjudfns",
                        productImage = "",
                        productPrice = 12000.0,
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "Ayam Bakar",
                        productDescription = "ajkfsjudfns",
                        productImage = "",
                        productPrice = 12000.0,
                        categoryId = "",
                        productUserId = ""
                    )
                ),
                onDetail = {},
                onEvent = {}
            )
        }
    }
}