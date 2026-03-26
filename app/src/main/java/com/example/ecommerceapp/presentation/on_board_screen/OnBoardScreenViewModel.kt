package com.example.ecommerceapp.presentation.on_board_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapp.domain.usecase.local_user_manager_usecase.LocalUserManagerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class OnBoardScreenViewModel @Inject constructor(
    private val localUserManagerUseCase: LocalUserManagerUseCase,
) : ViewModel() {
    // create on event function
    fun onEvent(event : OnBoardScreenEvent) {
        when(event) {
            is OnBoardScreenEvent.OnBoardEvent -> {
                viewModelScope.launch {
                    localUserManagerUseCase.setUserOnBoardUseCase()
                }
            }
        }
    }
}