package com.example.ecommerceapp.presentation.category_screen.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
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
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme

@Composable
fun CategoryItemWidget(category : CategoryModel) {
    // create local context
    val localContext = LocalContext.current

    Box(
        modifier = Modifier
            .padding(
                vertical = Dimension.MEDIUM_PADDING2,
                horizontal = Dimension.MEDIUM_PADDING1,
            )
            .shadow(
                elevation = 3.dp,
                shape = MaterialTheme.shapes.medium
            )
            .clip(
                shape = MaterialTheme.shapes.medium
            )
            .background(
                color = colorResource(
                    id = R.color.card_background_color2
                ),
                shape = MaterialTheme.shapes.medium
            )
            .padding(
                vertical = Dimension.MEDIUM_PADDING1,
                horizontal = Dimension.MEDIUM_PADDING2
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            Text(
                text = category.categoryName,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W800,
                    letterSpacing = 1.1.sp,
                    fontSize = 20.sp,
                    color = colorResource(
                        id = R.color.text_title,
                    )
                )
            )

            Spacer(
                modifier = Modifier
                    .height(
                        Dimension.MEDIUM_PADDING1
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        200.dp
                    )
                    .padding(
                        horizontal = Dimension.MEDIUM_PADDING2
                    )
                    .shadow(
                        elevation = 3.dp,
                        shape = MaterialTheme.shapes.medium
                    )
                    .clip(
                        shape = MaterialTheme.shapes.medium
                    )
                    .background(
                        color = MaterialTheme.colorScheme.background
                    )
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize(),
                    model = ImageRequest.Builder(
                        context = localContext
                    ).data("http://103.176.78.223${category.categoryImageUrl}").build(),
                    contentDescription = "Image Category",
                    contentScale = ContentScale.Crop,
                )
            }

            Spacer(
                modifier = Modifier
                    .height(
                        Dimension.MEDIUM_PADDING1
                    )
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = category.categoryDescription,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W600,
                    fontSize = 18.sp,
                    color = colorResource(
                        id = R.color.text_medium,
                    )
                ),
                textAlign = TextAlign.Justify,
            )

            Spacer(
                modifier = Modifier
                    .height(
                        Dimension.SMALL_PADDING2
                    )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        // for detail category to get all product based on category
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    contentPadding = PaddingValues(
                        horizontal = 2.dp,
                    )
                ) {
                    Text(
                        text = "more info...",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.W600,
                            letterSpacing = 1.1.sp,
                            fontSize = 14.sp,
                            color = colorResource(
                                id = R.color.text_title,
                            )
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CategoryItemWidgetPreview(){
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
            CategoryItemWidget(
                category = CategoryModel(
                    categoryName = "Makanan",
                    categoryDescription = "Makanan termasuk dengan makan berat untuk pagi siang dan malam",
                    categoryId = "1",
                    categoryImageUrl = ""
                )
            )
        }
    }
}