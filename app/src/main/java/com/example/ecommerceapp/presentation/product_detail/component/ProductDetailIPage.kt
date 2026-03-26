package com.example.ecommerceapp.presentation.product_detail.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.domain.models.CategoryModel
import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme
import java.text.NumberFormat
import java.util.Locale

@Composable
fun ProductDetailPage(
    product : ProductModel,
    categoryModel: CategoryModel
) {
    // create local context
    val localContext = LocalContext.current

    // get local currency
    val localCurr = NumberFormat.getCurrencyInstance(Locale.US)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                state = rememberScrollState()
            )
            .padding(
                vertical = Dimension.MEDIUM_PADDING1,
                horizontal = Dimension.MEDIUM_PADDING2
            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = product.productName,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.W800,
                letterSpacing = 1.1.sp,
                fontSize = 22.sp,
            ),
            color = colorResource(
                id = R.color.text_title
            )
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING2
                )
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(
                    180.dp
                )
                .padding(
                    horizontal = Dimension.MEDIUM_PADDING3
                )
                .shadow(
                    elevation = 4.dp,
                    shape = MaterialTheme.shapes.medium
                )
                .clip(
                    shape = MaterialTheme.shapes.medium
                )
                .background(
                    color = colorResource(
                        id = R.color.text_title
                    ),
                )
        ) {
            AsyncImage(
                model = ImageRequest.Builder(
                    localContext
                ).data(product.productImage).build(),
                contentDescription = "Product Image Placeholder",
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING2
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.money_ic
                ),
                contentDescription = "Money Icon",
                modifier = Modifier
                    .size(
                        20.dp
                    ),
                tint = colorResource(
                    id = R.color.text_title
                )
            )

            Spacer(
                modifier = Modifier
                    .width(
                        Dimension.SMALL_PADDING2
                    )
            )

            Text(
                text = localCurr.format(product.productPrice),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W600,
                    fontSize = 18.sp
                ),
                color = colorResource(
                    id = R.color.text_title
                )
            )
        }

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING2
                )
        )

        Text(
            text = "Product Description : ",
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 18.sp,
            ),
            color = colorResource(
                id = R.color.text_title,
            ),
            textAlign = TextAlign.Justify,
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.SMALL_PADDING2
                )
        )

        Text(
            text = product.productDescription,
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 18.sp,
            ),
            color = colorResource(
                id = R.color.text_title,
            ),
            textAlign = TextAlign.Justify,
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING2
                )
        )

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 1.5.dp,
            color = colorResource(
                id = R.color.text_title,
            )
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING2
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Product Category",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W700,
                    fontSize = 20.sp
                ),
                color = colorResource(
                    id = R.color.text_title
                )
            )
        }

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING2
                )
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 4.dp,
                    shape = MaterialTheme.shapes.medium
                )
                .clip(
                    shape = MaterialTheme.shapes.medium
                )
                .background(
                    color = colorResource(
                        id = R.color.card_background_color2,
                    ),
                    shape = MaterialTheme.shapes.medium
                )
                .padding(
                    vertical = Dimension.MEDIUM_PADDING1,
                    horizontal = Dimension.MEDIUM_PADDING2,
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = categoryModel.categoryName,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W600,
                        fontSize = 18.sp
                    ),
                    color = colorResource(
                        id = R.color.text_title
                    )
                )

                Spacer(
                    modifier = Modifier
                        .height(
                            Dimension.MEDIUM_PADDING2
                        )
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(
                            150.dp
                        )
                        .padding(
                            horizontal = Dimension.LARGE_PADDING3 * 2
                        )
                        .shadow(
                            elevation = 2.dp,
                            shape = MaterialTheme.shapes.medium
                        )
                        .clip(
                            shape = MaterialTheme.shapes.medium
                        )
                        .background(
                            color = colorResource(
                                id = R.color.text_title
                            )
                        )
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(
                            localContext
                        ).data(categoryModel.categoryImageUrl).build(),
                        contentDescription = "Category Image",
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )
                }

                Spacer(
                    modifier = Modifier
                        .height(
                            Dimension.MEDIUM_PADDING2
                        )
                )

                Text(
                    text = categoryModel.categoryDescription,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W600,
                    ),
                    color = colorResource(
                        id = R.color.text_title
                    ),
                    textAlign = TextAlign.Justify,
                )
            }
        }

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING2
                )
        )

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 1.5.dp,
            color = colorResource(
                id = R.color.text_title,
            )
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING2
                )
        )

        Button(
            onClick = {

            },
            shape = MaterialTheme.shapes.medium,
            colors = ButtonColors(
                containerColor = colorResource(
                    id = R.color.completed_label_background
                ),
                contentColor = colorResource(
                    id = R.color.white
                ),
                disabledContainerColor = colorResource(
                    id = R.color.completed_label_background
                ),
                disabledContentColor = colorResource(
                    id = R.color.white
                ),
            )
        ) {
            Text(
                text = "ADD TO CART",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W800
                ),
                color = colorResource(
                    id = R.color.completed_label_text
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProductDetailPagePreview() {
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
            ProductDetailPage(
                product = ProductModel(
                    productId = "",
                    productName = "Ayam Bakar",
                    productDescription = "Ayam Bakar adalah makanan yang terbuat dari ayam yang dibakar",
                    productPrice = 16000.0,
                    productImage = "",
                    categoryId = "1",
                    productUserId = ""
                ),
                categoryModel = CategoryModel(
                    categoryId = "",
                    categoryName = "Makanan",
                    categoryDescription = "Makanan termasuk makana berat, ringan dan snack yang dapat dikonsumsi kapanpun",
                    categoryImageUrl = ""
                )
            )
        }
    }
}