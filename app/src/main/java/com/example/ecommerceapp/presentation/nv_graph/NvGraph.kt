package com.example.ecommerceapp.presentation.nv_graph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommerceapp.presentation.auth_navigation.AuthNavigation
import com.example.ecommerceapp.presentation.main_navigation.MainNavigation
import com.example.ecommerceapp.presentation.on_board_screen.OnBoardScreen
import com.example.ecommerceapp.presentation.on_board_screen.OnBoardScreenEvent
import com.example.ecommerceapp.presentation.on_board_screen.OnBoardScreenViewModel

@Composable
fun NvGraph(route : String) {
    // create nav controller
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = route,
    ) {
        composable(
            route = Routes.MainScreenRoutes.route
        ) {
            // show main screen routes
            MainNavigation()
        }

        composable(
            route = Routes.AuthUserRoutes.route
        ) {
            AuthNavigation()
        }

        composable(
            route = Routes.OnBoardScreenRoutes.route
        ) {
            // create on board view model
            val onBoardViewModel : OnBoardScreenViewModel = hiltViewModel()

            // show onboard screen
            OnBoardScreen(
                onEvent = {
                    event : OnBoardScreenEvent ->
                    onBoardViewModel.onEvent(event)
                }
            )
        }
    }
}