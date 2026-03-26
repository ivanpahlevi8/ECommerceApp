package com.example.ecommerceapp.presentation.on_board_screen

import androidx.annotation.DrawableRes
import com.example.ecommerceapp.R

data class OnBoardItemModel (
    @DrawableRes val imageId : Int,
    val title : String,
    val content : String,
)

// create list of on board item model
var onBoardItemList : List<OnBoardItemModel> = listOf(
    OnBoardItemModel(
        imageId = R.drawable.onboard_image_1,
        title = "More Fresh",
        content = "It has more fresh looks with new style and new API to increase user experience when using this app",
    ),
    OnBoardItemModel(
        imageId = R.drawable.onboard_image_2,
        title = "More Feature",
        content = "With new API on behind the scene make interaction with you more interactive and smooth",
    ),
    OnBoardItemModel(
        imageId = R.drawable.onboard_image_3,
        title = "More Feature",
        content = "With new API on behind the scene make interaction with you more interactive and smooth",
    ),
)