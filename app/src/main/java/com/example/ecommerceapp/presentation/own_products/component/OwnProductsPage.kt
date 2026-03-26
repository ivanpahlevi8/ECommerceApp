package com.example.ecommerceapp.presentation.own_products.component

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
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme

@Composable
fun OwnProductsPage(
    productList : List<ProductModel>,
    onDelete : (ProductModel) -> Unit,
    onUpdate : (ProductModel) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize(),
    ) {
        items(
            count = productList.size
        ) {
            index : Int ->
            // get item
            val getItem : ProductModel = productList[index]

            // show product item
            OwnProductsItem(
                productItem = getItem,
                onDelete = onDelete,
                onUpdate = onUpdate,
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OwnProductsPagePreview() {
    ECommerceAppTheme {
        Box(
            modifier = Modifier
                .padding(
                    Dimension.MEDIUM_PADDING1
                )
                .background(
                    color = MaterialTheme.colorScheme.background
                )
        ) {
            OwnProductsPage(
                productList = listOf(
                    ProductModel(
                        productId = "",
                        productName = "Ferrari SF19 Stradale",
                        productDescription = "",
                        productImage = "",
                        productPrice = 1000000000000.0,
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "Ferrari SF19 Stradale",
                        productDescription = "",
                        productImage = "",
                        productPrice = 1000000000000.0,
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "Ferrari SF19 Stradale",
                        productDescription = "",
                        productImage = "",
                        productPrice = 1000000000000.0,
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "Ferrari SF19 Stradale",
                        productDescription = "",
                        productImage = "",
                        productPrice = 1000000000000.0,
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "Ferrari SF19 Stradale",
                        productDescription = "",
                        productImage = "",
                        productPrice = 1000000000000.0,
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "Ferrari SF19 Stradale",
                        productDescription = "",
                        productImage = "",
                        productPrice = 1000000000000.0,
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "Ferrari SF19 Stradale",
                        productDescription = "",
                        productImage = "",
                        productPrice = 1000000000000.0,
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "Ferrari SF19 Stradale",
                        productDescription = "",
                        productImage = "",
                        productPrice = 1000000000000.0,
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "Ferrari SF19 Stradale",
                        productDescription = "",
                        productImage = "",
                        productPrice = 1000000000000.0,
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "Ferrari SF19 Stradale",
                        productDescription = "",
                        productImage = "",
                        productPrice = 1000000000000.0,
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "Ferrari SF19 Stradale",
                        productDescription = "",
                        productImage = "",
                        productPrice = 1000000000000.0,
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "Ferrari SF19 Stradale",
                        productDescription = "",
                        productImage = "",
                        productPrice = 1000000000000.0,
                        categoryId = "",
                        productUserId = ""
                    )
                ),
                onDelete = {},
                onUpdate = {}
            )
        }
    }
}