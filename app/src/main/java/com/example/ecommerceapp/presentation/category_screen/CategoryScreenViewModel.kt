package com.example.ecommerceapp.presentation.category_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapp.domain.models.CategoryModel
import com.example.ecommerceapp.domain.usecase.category_remote_usecase.CategoryRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class CategoryScreenViewModel @Inject constructor(
    private val categoryRemoteUseCase: CategoryRemoteUseCase
) : ViewModel() {
    // create local state for category
    private var _categoryLocalState by mutableStateOf<CategoryScreenState>(CategoryScreenState.LoadingState)

    // exposed local state for category
    val categoryLocalState : State<CategoryScreenState> get() = derivedStateOf { _categoryLocalState }

    // create init function
    init {
        viewModelScope.launch {
            // add delay for better transition
            delay(500)

            try{
                // get list of category
                val getData : List<CategoryModel> = categoryRemoteUseCase.getAllCategoryUseCase()

                // update state into data state
                _categoryLocalState = CategoryScreenState.DataState(
                    data = getData
                )
            } catch (e : Exception) {
                // create error message
                val errMsg : String = "Error Happen : ${e.message}"

                // update state into error state
                _categoryLocalState = CategoryScreenState.ErrorState(errMsg = errMsg)
            }
        }
    }
}