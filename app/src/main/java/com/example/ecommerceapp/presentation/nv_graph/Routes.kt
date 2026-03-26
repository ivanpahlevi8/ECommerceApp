package com.example.ecommerceapp.presentation.nv_graph

sealed class Routes(
    val route : String,
) {
    object OnBoardScreenRoutes : Routes(route = "onboard-screen-routes")
    object MainScreenRoutes : Routes(route = "main-screen-routes")

    object AuthUserRoutes : Routes(route = "auth-user-routes")
    object RegisterUserRoutes : Routes(route = "register-user-routes")
    object LoginUserRoutes : Routes(route = "login-user-routes")

    object CategoryScreenRoutes : Routes(route = "category-screen-routes")
    object AllProductRoutes : Routes(route = "all-product-routes")
    object AddProductRoutes : Routes(route = "add-product-routes")
    object OwnProductsRoutes : Routes(route = "own-products-routes")
    object OwnProductsUpdateRoutes : Routes(route = "own-products-update-routes")
    object ProductDetailRoutes : Routes(route = "product-detail-routes")
    object CartRoutes : Routes(route = "cart-routes")
    object OrderRoutes : Routes(route = "order-routes")
    object OrderHistoryRoute : Routes(route = "order-history-routes")

    object ProfileScreenRoutes : Routes(route = "profile-screen-routes")
    object UpdateProfileScreenRoutes : Routes(route = "update-profile-screen-routes")
}