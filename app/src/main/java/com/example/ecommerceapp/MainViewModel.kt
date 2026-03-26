package com.example.ecommerceapp

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceapp.domain.usecase.local_user_manager_usecase.LocalUserManagerUseCase
import com.example.ecommerceapp.presentation.nv_graph.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val localUserManagerUseCase: LocalUserManagerUseCase
) : ViewModel() {

    var initialRoute by mutableStateOf(Routes.OnBoardScreenRoutes.route)
        private set // Good practice: prevent UI from changing this directly

    var showSplashScreen by mutableStateOf(true)
        private set

    init {
        viewModelScope.launch {
            val onBoardFlow = localUserManagerUseCase.getUserOnBoardUseCase()
            val loggedInFlow = localUserManagerUseCase.getUserLoggedInUseCase()

            combine(onBoardFlow, loggedInFlow) { isOnboarded, isLoggedIn ->
                when {
                    !isOnboarded -> Routes.OnBoardScreenRoutes.route
                    !isLoggedIn -> Routes.AuthUserRoutes.route
                    else -> Routes.MainScreenRoutes.route
                }
            }
                .onStart { delay(500) } // Your transition delay
                .catch { error ->
                    Log.e("MainViewModel", "Flow Error: ${error.message}")
                    emit(Routes.OnBoardScreenRoutes.route) // Fallback on error
                }
                .collect { route ->
                    initialRoute = route
                    showSplashScreen = false
                }
        }
    }
}