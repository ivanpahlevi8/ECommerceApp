package com.example.ecommerceapp.presentation.product_detail

import android.content.SharedPreferences
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapp.core.value.Constants
import com.example.ecommerceapp.domain.models.CategoryModel
import com.example.ecommerceapp.domain.models.ProductModel
import com.example.ecommerceapp.domain.usecase.category_remote_usecase.CategoryRemoteUseCase
import com.example.ecommerceapp.domain.usecase.product_remote_usecase.ProductRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val productRemoteUseCase: ProductRemoteUseCase,
    private val categoryRemoteUseCase: CategoryRemoteUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    // create local state for product detail
    private var _productDetailState by mutableStateOf<ProductDetailState>(ProductDetailState.LoadingState)

    // exposed local state for product detail
    val productDataDetail : State<ProductDetailState> get() = derivedStateOf { _productDetailState }

    init {
        viewModelScope.launch {
            // add some delay for better transition
            delay(500)

            try{
                // product id from uri
                val getProductId = savedStateHandle["productId"] ?: ""

                // get product by id
                val getProduct : ProductModel = productRemoteUseCase.getProductByIdUseCase(
                    productId = getProductId
                )

                // update product image
                getProduct.productImage = "${Constants.BASE_URL}${getProduct.productImage}"

                // get category by id
                val getCategory : CategoryModel = categoryRemoteUseCase.getCategoryUseCase(
                    categoryId = getProduct.categoryId
                )

                // update state into data state
                _productDetailState = ProductDetailState.DataState(
                    product = getProduct,
                    category = getCategory,
                )
            } catch (e : Exception) {
                // create error message
                val errMsg : String = "Error happen : ${e.message}, ${e.stackTrace}"

                // update state into error state
                _productDetailState = ProductDetailState.ErrorState(
                    errMsg = errMsg
                )
            }
        }
    }
}