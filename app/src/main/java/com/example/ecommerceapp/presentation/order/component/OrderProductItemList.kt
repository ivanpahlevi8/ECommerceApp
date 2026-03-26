package com.example.ecommerceapp.presentation.order.component

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme

@Composable
fun OrderProductItemList(
    itemList : List<ProductModel>,
    showProduct : Boolean
) {
    AnimatedVisibility(
        visible = showProduct
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            for(item : ProductModel in itemList) {
                // show data
                OrderProductItem(
                    product = item
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OrderProductItemListShimmer() {
    ECommerceAppTheme {
        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.background
                )
                .padding(
                    Dimension.MEDIUM_PADDING1
                )
        ) {
            OrderProductItemList(
                showProduct = true,
                itemList = listOf(
                    ProductModel(
                        productId = "",
                        productName = "MSI GF63",
                        productDescription = "Laptop dengan spesifikasi Intel Core i7 generasi ke 10 dan kartu grafis Nvidia GTX 1050 Ti dengan VRam 4Gb dan Ram 16 GB penyimpanan 2 tb",
                        productPrice = 10000000.0,
                        productImage = "",
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "MSI GF63",
                        productDescription = "Laptop dengan spesifikasi Intel Core i7 generasi ke 10 dan kartu grafis Nvidia GTX 1050 Ti dengan VRam 4Gb dan Ram 16 GB penyimpanan 2 tb",
                        productPrice = 10000000.0,
                        productImage = "",
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "MSI GF63",
                        productDescription = "Laptop dengan spesifikasi Intel Core i7 generasi ke 10 dan kartu grafis Nvidia GTX 1050 Ti dengan VRam 4Gb dan Ram 16 GB penyimpanan 2 tb",
                        productPrice = 10000000.0,
                        productImage = "",
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "MSI GF63",
                        productDescription = "Laptop dengan spesifikasi Intel Core i7 generasi ke 10 dan kartu grafis Nvidia GTX 1050 Ti dengan VRam 4Gb dan Ram 16 GB penyimpanan 2 tb",
                        productPrice = 10000000.0,
                        productImage = "",
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "MSI GF63",
                        productDescription = "Laptop dengan spesifikasi Intel Core i7 generasi ke 10 dan kartu grafis Nvidia GTX 1050 Ti dengan VRam 4Gb dan Ram 16 GB penyimpanan 2 tb",
                        productPrice = 10000000.0,
                        productImage = "",
                        categoryId = "",
                        productUserId = ""
                    ),
                    ProductModel(
                        productId = "",
                        productName = "MSI GF63",
                        productDescription = "Laptop dengan spesifikasi Intel Core i7 generasi ke 10 dan kartu grafis Nvidia GTX 1050 Ti dengan VRam 4Gb dan Ram 16 GB penyimpanan 2 tb",
                        productPrice = 10000000.0,
                        productImage = "",
                        categoryId = "",
                        productUserId = ""
                    )
                )
            )
        }
    }
}