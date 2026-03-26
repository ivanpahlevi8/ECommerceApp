package com.example.ecommerceapp.presentation.on_board_screen.component

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme

@Composable
fun OnBoardItem(
    @DrawableRes image : Int,
    title : String,
    content : String,
    showNextButton : Boolean,
    showBackButton : Boolean,
    showFinishButton : Boolean,
    onNext : () -> Unit,
    onBack : () -> Unit,
    onFinish : () -> Unit,
){
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(
                    id = image
                ),
                modifier = Modifier
                    .fillMaxSize(),
                contentDescription = "Placeholder Image",
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Black.copy(
                                    alpha = 0.6f
                                ),
                                Color.White.copy(
                                    alpha = 0.7f
                                ),
                            ),
                            startY = 0.6f
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(
                        alignment = Alignment.BottomCenter
                    ),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W800,
                        letterSpacing = 1.1.sp,
                        fontSize = 20.sp,
                    ),
                    color = colorResource(
                        id = R.color.black,
                    )
                )

                Spacer(
                    modifier = Modifier
                        .height(Dimension.MEDIUM_PADDING1)
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = content,
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W600,
                        letterSpacing = 1.1.sp,
                        fontSize = 18.sp,
                    ),
                    color = colorResource(
                        id = R.color.black,
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
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                ) {
                    if (showBackButton) {
                        Button(
                            onClick = onBack,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.error_color)
                            ),
                            shape = MaterialTheme.shapes.medium,
                            modifier = Modifier.padding(Dimension.SMALL_PADDING2)
                        ) {
                            Text(
                                text = "Back",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.W500,
                                    fontSize = 16.sp
                                ),
                                color = colorResource(id = R.color.white)
                            )
                        }
                    }

                    if (showNextButton || showFinishButton) {
                        val text = if (showFinishButton) "Finish" else "Next"
                        val action = if (showFinishButton) onFinish else onNext

                        Button(
                            onClick = action,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.excellent_start)
                            ),
                            shape = MaterialTheme.shapes.medium,
                            modifier = Modifier.padding(Dimension.SMALL_PADDING2)
                        ) {
                            Text(
                                text = text,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.W500,
                                    fontSize = 16.sp
                                ),
                                color = colorResource(id = R.color.white)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OnBoardItemPreview(){
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
            OnBoardItem(
                image = R.drawable.onboard_image_1,
                title = "More Fresh",
                content = "It has more fresh looks with new style and new API to increase user experience when using this app",
                showFinishButton = false,
                showBackButton = true,
                showNextButton = true,
                onBack = {},
                onFinish = {},
                onNext = {}
            )
        }
    }
}