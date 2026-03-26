package com.example.ecommerceapp.presentation.add_product.component

import android.content.Context
import android.content.res.Configuration
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.example.ecommerceapp.R
import com.example.ecommerceapp.core.value.Dimension
import com.example.ecommerceapp.domain.models.CategoryModel
import com.example.ecommerceapp.domain.models.InsertProductModel
import com.example.ecommerceapp.presentation.add_product.AddProductEvent
import com.example.ecommerceapp.presentation.add_product.AddProductState
import com.example.ecommerceapp.presentation.auth_screen.component.InputItem
import com.example.ecommerceapp.ui.theme.ECommerceAppTheme
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductPage(
    categoryList : List<CategoryModel>,
    onEvent : (AddProductEvent) -> Unit,
) {
    // create local context
    val localContext = LocalContext.current

    // create input for product
    var inputProductName by remember { mutableStateOf("") }
    var inputProductDescription by remember { mutableStateOf("") }
    var inputProductPrice by remember { mutableStateOf("") }
    var inputProductCategory by remember { mutableStateOf("") }

    var selectedCategoryId by remember { mutableStateOf(0) }
    var showDropDown by remember { mutableStateOf(false) }

    var urlString by remember { mutableStateOf("") }
    var multipart by remember { mutableStateOf<MultipartBody.Part?>(null) }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        //When the user has selected a photo, its URI is returned here
        if(uri != null) {
            urlString = uri.path.toString()
            multipart = uriToMultipart(localContext, uri)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Upload Your Product",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.W800,
                letterSpacing = 1.1.sp,
                fontSize = 20.sp,
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

        InputItem(
            value = inputProductName,
            onChange = {
                newValue : String -> inputProductName = newValue
            },
            labelText = "Product Name"
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.SMALL_PADDING1
                )
        )

        InputItem(
            value = inputProductDescription,
            onChange = {
                    newValue : String -> inputProductDescription = newValue
            },
            labelText = "Product Description"
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.SMALL_PADDING1
                )
        )

        InputItem(
            value = inputProductPrice,
            onChange = {
                    newValue : String -> inputProductPrice = newValue
            },
            labelText = "Product Description"
        )

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.SMALL_PADDING1
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            InputItem(
                modifier = Modifier
                    .weight(1f),
                value = inputProductCategory,
                readonly = true,
                onChange = {},
                labelText = "Category"
            )

            Spacer(
                modifier = Modifier
                    .width(
                        Dimension.SMALL_PADDING2
                    )
            )

            Box(modifier = Modifier.wrapContentSize(Alignment.TopStart)) {
                Button(
                    onClick = { showDropDown = true },
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(text = "Category")
                }

                // This component automatically floats "on top"
                DropdownMenu(
                    expanded = showDropDown,
                    onDismissRequest = { showDropDown = false },
                    modifier = Modifier
                        .width(200.dp)
                        .heightIn(max = 200.dp) // Limits height so it doesn't cover the whole screen
                ) {
                    categoryList.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(item.categoryName) },
                            onClick = {
                                inputProductCategory = item.categoryName
                                selectedCategoryId = item.categoryId.toInt()
                                showDropDown = false
                            }
                        )
                    }
                }
            }
        }

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.SMALL_PADDING1
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            InputItem(
                modifier = Modifier
                    .weight(1f),
                value = urlString,
                onChange = {
                        newValue : String -> urlString = newValue
                },
                labelText = "Image",
                readonly = true,
            )
            Spacer(
                modifier = Modifier
                    .width(
                        Dimension.SMALL_PADDING1
                    )
            )

            Button(
                shape = RoundedCornerShape(size = 8.dp),
                onClick = {
                    //On button press, launch the photo picker
                    launcher.launch(
                        PickVisualMediaRequest(
                            mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                        )
                    )
                }
            ) {
                Text("Select")
            }
        }

        Spacer(
            modifier = Modifier
                .height(
                    Dimension.MEDIUM_PADDING3
                )
        )

        Button(
            onClick = {
                Log.d("CHECK", "Check on multipart : ${multipart?.headers.toString()}")
                onEvent(
                    AddProductEvent.AddProduct(
                        productInsert = InsertProductModel(
                            productId = "0",
                            productName = inputProductName,
                            productDescription = inputProductDescription,
                            productImage = "a",
                            image = multipart!!,
                            productPrice = inputProductPrice,
                            categoryId = selectedCategoryId.toString(),
                            userId = ""
                        )
                    )
                )
            },
            shape = MaterialTheme.shapes.medium,
            colors = ButtonColors(
                containerColor = colorResource(
                    id = R.color.excellent_end
                ),
                contentColor = colorResource(
                    id = R.color.white
                ),
                disabledContainerColor = colorResource(
                    id = R.color.excellent_end
                ),
                disabledContentColor = colorResource(
                    id = R.color.white
                ),
            )
        ) {
            Text(
                text = "INSERT",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W600,
                    letterSpacing = 1.1.sp,
                    fontSize = 18.sp,
                ),
                color = colorResource(
                    id = R.color.white
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AddProductPagePreview() {
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
            AddProductPage(
                categoryList = listOf(
                    CategoryModel(
                        categoryId = "",
                        categoryName = "Makanan",
                        categoryDescription = "",
                        categoryImageUrl = ""
                    )
                ),
                onEvent = {}
            )
        }
    }
}

fun uriToMultipart(context: Context, uri: Uri): MultipartBody.Part? {
    // 1. Get the actual file name from the Uri
    val fileName = context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
        val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        cursor.moveToFirst()
        cursor.getString(nameIndex)
    } ?: "upload_${System.currentTimeMillis()}.jpg" // Fallback name if query fails

    // 2. Create the temporary file in cache using the real name
    val file = File(context.cacheDir, fileName)

    val inputStream = context.contentResolver.openInputStream(uri)

    // 3. Copy stream to file
    inputStream?.use { input ->
        file.outputStream().use { output ->
            input.copyTo(output)
        }
    }

    // 4. Create the RequestBody and MultipartBody.Part
    val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())

    // The first "image" is the key your API expects
    return MultipartBody.Part.createFormData("image", file.name, requestFile)
}