package com.example.ecommerceapp.presentation.auth_navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommerceapp.presentation.auth_screen.AuthRegisterScreen
import com.example.ecommerceapp.presentation.auth_screen.AuthScreenViewModel
import com.example.ecommerceapp.presentation.auth_screen.LoginUserScreen
import com.example.ecommerceapp.presentation.nv_graph.Routes

@Composable
fun AuthNavigation() {
    // create nav controller
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.LoginUserRoutes.route,
    ){
        composable(
            route = Routes.LoginUserRoutes.route
        ) {
            // create auth screen view model
            val authScreenViewModel : AuthScreenViewModel = hiltViewModel()

            LoginUserScreen(
                onRegister = {
                    navController.navigate(
                        Routes.RegisterUserRoutes.route
                    )
                },
                onEvent = {
                    event -> authScreenViewModel.onEvent(event)
                },
                authState = authScreenViewModel.loginAuthState.value,
                setState = {
                    state -> authScreenViewModel.setLoginState(state)
                }
            )
        }

        composable(
            route = Routes.RegisterUserRoutes.route
        ) {
            // create auth screen view model
            val authScreenViewModel : AuthScreenViewModel = hiltViewModel()

            // show register screen
            AuthRegisterScreen(
                onEvent = {
                    event -> authScreenViewModel.onEvent(event)
                },
                authState = authScreenViewModel.registerAuthState.value,
                setState = {
                    state -> authScreenViewModel.setState(state)
                }
            )
        }
    }
}