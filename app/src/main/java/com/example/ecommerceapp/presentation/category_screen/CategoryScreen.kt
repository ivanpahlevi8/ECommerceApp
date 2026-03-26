package com.example.ecommerceapp.presentation.category_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.ecommerceapp.R
import com.example.ecommerceapp.domain.models.CategoryModel
import com.example.ecommerceapp.presentation.category_screen.component.CategoryItemListWidget
import com.example.ecommerceapp.presentation.category_screen.component.CategoryItemListWidgetShimmer

@Composable
fun CategoryScreen(state: CategoryScreenState) {
    when(state) {
        is CategoryScreenState.DataState -> {
            // get data
            val getData : List<CategoryModel> = state.data

            // show data
            CategoryItemListWidget(
                itemList = getData
            )
        }
        is CategoryScreenState.ErrorState -> {
            // get error message
            val errMsg : String = state.errMsg

            // show error view
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = errMsg,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W600,
                        fontSize = 17.sp,
                        color = colorResource(
                            id = R.color.error_color
                        )
                    ),
                    textAlign = TextAlign.Justify,
                )
            }
        }
        is CategoryScreenState.LoadingState -> {
            CategoryItemListWidgetShimmer()
        }
    }
}