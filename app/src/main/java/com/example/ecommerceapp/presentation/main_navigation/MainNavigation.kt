package com.example.ecommerceapp.presentation.main_navigation

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ecommerceapp.R
import com.example.ecommerceapp.presentation.add_product.AddProductScreen
import com.example.ecommerceapp.presentation.add_product.AddProductViewModel
import com.example.ecommerceapp.presentation.all_product.AllProductScreen
import com.example.ecommerceapp.presentation.all_product.AllProductViewModel
import com.example.ecommerceapp.presentation.cart.CartScreen
import com.example.ecommerceapp.presentation.cart.CartViewModel
import com.example.ecommerceapp.presentation.category_screen.CategoryScreen
import com.example.ecommerceapp.presentation.category_screen.CategoryScreenViewModel
import com.example.ecommerceapp.presentation.main_navigation.component.NavBarItem
import com.example.ecommerceapp.presentation.main_navigation.component.NavigationDrawer
import com.example.ecommerceapp.presentation.nv_graph.Routes
import com.example.ecommerceapp.presentation.order.FinishedOrderMainScreen
import com.example.ecommerceapp.presentation.order.OrderFinishedViewModel
import com.example.ecommerceapp.presentation.order.OrderMainScreen
import com.example.ecommerceapp.presentation.order.OrderScreen
import com.example.ecommerceapp.presentation.order.OrderViewModel
import com.example.ecommerceapp.presentation.own_products.OwnProductsEvent
import com.example.ecommerceapp.presentation.own_products.OwnProductsScreen
import com.example.ecommerceapp.presentation.own_products.OwnProductsViewModel
import com.example.ecommerceapp.presentation.own_products_update.OwnProductsUpdateScreen
import com.example.ecommerceapp.presentation.own_products_update.OwnProductsUpdateViewModel
import com.example.ecommerceapp.presentation.product_detail.ProductDetailScreen
import com.example.ecommerceapp.presentation.product_detail.ProductDetailViewModel
import com.example.ecommerceapp.presentation.profile_screen.ProfileScreen
import com.example.ecommerceapp.presentation.profile_screen.ProfileScreenViewModel
import com.example.ecommerceapp.presentation.update_profile.UpdateProfileScreen
import com.example.ecommerceapp.presentation.update_profile.UpdateProfileViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigation() {
    // create nav bar item
    val navBarItemList : List<NavBarItem> = listOf(
        NavBarItem(
            title = "Categories",
            icon = R.drawable.category_ic,
        ),
        NavBarItem(
            title = "On Sale Product",
            icon = R.drawable.inventory_ic,
        ),
        NavBarItem(
            title = "Own Product",
            icon = R.drawable.inventory_ic,
        ),
        NavBarItem(
            title = "Order",
            icon = R.drawable.local_shipping_ic
        ),
        NavBarItem(
            title = "History Order",
            icon = R.drawable.history_ic,
        )
    )

    // create nav controller
    val navController = rememberNavController()

    // get current route
    val getCurrentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    // get index selected route
    val indexSelectedRoute: Int = when {
        getCurrentRoute == Routes.CategoryScreenRoutes.route -> 0
        getCurrentRoute == Routes.AllProductRoutes.route -> 1
        getCurrentRoute == Routes.OwnProductsRoutes.route -> 2
        getCurrentRoute == Routes.OrderRoutes.route -> 3
        getCurrentRoute == Routes.OrderHistoryRoute.route -> 4
        getCurrentRoute == Routes.ProfileScreenRoutes.route -> 5
        getCurrentRoute?.startsWith(Routes.UpdateProfileScreenRoutes.route) == true -> 6
        getCurrentRoute == Routes.AddProductRoutes.route -> 7
        getCurrentRoute?.startsWith(Routes.OwnProductsUpdateRoutes.route) == true -> 8
        getCurrentRoute?.startsWith(Routes.ProductDetailRoutes.route) == true -> 9
        getCurrentRoute?.startsWith(Routes.CartRoutes.route) == true -> 10
        else -> 0
    }

    // create state for showing top app bar or not
    val showTopAppBar : Boolean = when(getCurrentRoute) {
        Routes.CategoryScreenRoutes.route -> {
            true
        }
        else -> {
            true
        }
    }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    NavigationDrawer(
        itemList = navBarItemList,
        selectedItem = indexSelectedRoute,
        onClick = {
            index : Int ->
            when(index) {
                0 -> {
                    // close the drawer
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }

                    // navigate to destination tab
                    onMoveTab(
                        navController = navController,
                        route = Routes.CategoryScreenRoutes.route
                    )
                }
                1 -> {
                    // close the drawer
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }

                    // navigate to destination tab
                    onMoveTab(
                        navController = navController,
                        route = Routes.AllProductRoutes.route
                    )
                }
                2 -> {
                    // close the drawer
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }

                    // navigate to destination tab
                    onMoveTab(
                        navController = navController,
                        route = Routes.OwnProductsRoutes.route
                    )
                }
                3 -> {
                    // close the drawer
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }

                    // navigate to destination tab
                    onMoveTab(
                        navController = navController,
                        route = Routes.OrderRoutes.route
                    )
                }
                4 -> {
                    // close the drawer
                    scope.launch {
                        drawerState.apply {
                            close()
                        }
                    }

                    // navigate to destination tab
                    onMoveTab(
                        navController = navController,
                        route = Routes.OrderHistoryRoute.route
                    )
                }
            }
        },
        drawerState = drawerState,
        onProfile = {
            scope.launch {
                drawerState.apply {
                    close()
                }
            }
            navController.navigate(Routes.ProfileScreenRoutes.route)
        },
        item = {
            Scaffold (
                topBar = { //TopBar to show title
                    TopAppBar(
                        title = {
                            when(indexSelectedRoute) {
                                0 -> {
                                    Text(
                                        text = "Category",
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.W600,
                                            letterSpacing = 1.1.sp,
                                            fontSize = 20.sp,
                                        ),
                                        color = colorResource(
                                            id = R.color.text_title,
                                        )
                                    )
                                }
                                2 -> {
                                    Text(
                                        text = "Your Products",
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.W600,
                                            letterSpacing = 1.1.sp,
                                            fontSize = 20.sp,
                                        ),
                                        color = colorResource(
                                            id = R.color.text_title,
                                        )
                                    )
                                }
                                3 -> {
                                    Text(
                                        text = "Current Order",
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.W600,
                                            letterSpacing = 1.1.sp,
                                            fontSize = 20.sp,
                                        ),
                                        color = colorResource(
                                            id = R.color.text_title,
                                        )
                                    )
                                }
                                4 -> {
                                    Text(
                                        text = "Order History",
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.W600,
                                            letterSpacing = 1.1.sp,
                                            fontSize = 20.sp,
                                        ),
                                        color = colorResource(
                                            id = R.color.text_title,
                                        )
                                    )
                                }
                                6 -> {
                                    Text(
                                        text = "Update Product Page",
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.W600,
                                            letterSpacing = 1.1.sp,
                                            fontSize = 20.sp,
                                        ),
                                        color = colorResource(
                                            id = R.color.text_title,
                                        )
                                    )
                                }
                                7 -> {
                                    Text(
                                        text = "Product Detail",
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.W600,
                                            letterSpacing = 1.1.sp,
                                            fontSize = 20.sp,
                                        ),
                                        color = colorResource(
                                            id = R.color.text_title,
                                        )
                                    )
                                }
                                8 -> {
                                    Text(
                                        text = "Your Cart",
                                        style = MaterialTheme.typography.titleMedium.copy(
                                            fontWeight = FontWeight.W600,
                                            letterSpacing = 1.1.sp,
                                            fontSize = 20.sp,
                                        ),
                                        color = colorResource(
                                            id = R.color.text_title,
                                        )
                                    )
                                }
                            }
                        },
                        navigationIcon = {
                            when(indexSelectedRoute) {
                                0,1,2,3,4 -> {
                                    IconButton(onClick = {
                                        scope.launch {
                                            drawerState.apply {
                                                if (isClosed) open() else close()
                                            }
                                        }
                                    }) {
                                        Icon(  //Show Menu Icon on TopBar
                                            imageVector = Icons.Default.Menu,
                                            contentDescription = "Menu"
                                        )
                                    }
                                }
                                5,6,7,8,9,10 -> {
                                    IconButton(onClick = {
                                        navController.popBackStack()
                                    }) {
                                        Icon(  //Show Menu Icon on TopBar
                                            imageVector = Icons.Default.KeyboardArrowLeft,
                                            contentDescription = "Menu",
                                            modifier = Modifier
                                                .size(30.dp)
                                        )
                                    }
                                }
                            }
                        },
                        actions = {
                            IconButton(
                                onClick = {
                                    navController.navigate(
                                        Routes.AddProductRoutes.route,
                                    )
                                }
                            ) {
                                when(indexSelectedRoute) {
                                    0,1,2,3,4 -> {
                                        Icon(
                                            painter = painterResource(
                                                id = R.drawable.add_box_ic
                                            ),
                                            contentDescription = "Add Box Icon",
                                            tint = colorResource(
                                                id = R.color.white,
                                            )
                                        )
                                    }
                                }
                            }

                            IconButton(
                                onClick = {
                                    navController.navigate(
                                        Routes.CartRoutes.route
                                    )
                                }
                            ) {
                                Icon(
                                    painter = painterResource(
                                        id = R.drawable.add_shopping_cart_ic
                                    ),
                                    contentDescription = "Shopping Cart Icon",
                                    tint = colorResource(
                                        id = R.color.white,
                                    )
                                )
                            }
                        }
                    )
                }
            ){
                val bottomPaddingValue = it.calculateBottomPadding()
                val topPaddingValue = it.calculateTopPadding()

                NavHost(
                    navController = navController,
                    startDestination = Routes.CategoryScreenRoutes.route,
                    modifier = Modifier.padding(
                        top = topPaddingValue,
                        bottom = bottomPaddingValue
                    )
                ){
                    // create route for category
                    composable(
                        route = Routes.CategoryScreenRoutes.route
                    ) {
                        // create category view model
                        val categoryScreenViewModel : CategoryScreenViewModel = hiltViewModel()

                        // show screen
                        CategoryScreen(
                            state = categoryScreenViewModel.categoryLocalState.value
                        )
                    }

                    // create route for all product
                    composable(
                        route = Routes.AllProductRoutes.route
                    ) {
                        // create all product view model
                        val allProductViewModel : AllProductViewModel = hiltViewModel()

                        // show screen
                        AllProductScreen(
                            state = allProductViewModel.allProductState.value,
                            onRefresh = {
                                allProductViewModel.onRefresh()
                            },
                            refreshState = allProductViewModel.refreshState,
                            onDetail = {
                                productId : String -> navController.navigate(
                                    Routes.ProductDetailRoutes.route + "/${productId}"
                                )
                            },
                            onEvent = {
                                event -> allProductViewModel.onEvent(
                                    event
                                )
                            },
                            addCartProductState = allProductViewModel.addCartProductState.value,
                            updateCartProductState = {
                                state -> allProductViewModel.updateAddCartState(
                                    state = state
                                )
                            }
                        )
                    }

                    // create route for profile detail
                    composable(
                        route = Routes.ProfileScreenRoutes.route
                    ) {
                        // create profile screen view model
                        val profileScreenViewModel : ProfileScreenViewModel = hiltViewModel()

                        // show screen
                        ProfileScreen(
                            state = profileScreenViewModel.getProfileState.value,
                            onUpdate = {
                                userName : String ->
                                navController.navigate(Routes.UpdateProfileScreenRoutes.route + "/$userName")
                            }
                        )
                    }

                    // create route for update profile
                    composable(
                        route = Routes.UpdateProfileScreenRoutes.route + "/{username}",
                        arguments = listOf(navArgument("username") { type = NavType.StringType })
                    ) {
                        // create update profile view model
                        val updateProfileViewModel : UpdateProfileViewModel = hiltViewModel()

                        // show update profile screen
                        UpdateProfileScreen(
                            state = updateProfileViewModel.initEntryState.value,
                            updateState = updateProfileViewModel.updateProfileState.value,
                            onEvent = {
                                event -> updateProfileViewModel.onEvent(
                                    event
                                )
                            },
                            changeUpdateState = {
                                state -> updateProfileViewModel.changeUpdateProfileState(state)
                            }
                        )
                    }

                    // create route for add product
                    composable(
                        route = Routes.AddProductRoutes.route,
                    ) {
                        // create add product view model
                        val addProductViewModel : AddProductViewModel = hiltViewModel()

                        // show add product screen
                        AddProductScreen(
                            initState = addProductViewModel.initDataState.value,
                            onEvent = {
                                event -> addProductViewModel.onEvent(
                                    event = event,
                                )
                            },
                            addProductState = addProductViewModel.addProductState.value,
                            updateAddProductState = {
                                newState -> addProductViewModel.updateAddProductState(
                                    state = newState
                                )
                            }
                        )
                    }

                    // create route for own product
                    composable(
                        route = Routes.OwnProductsRoutes.route
                    ) {
                        // create own product view model
                        val ownProductsViewModel : OwnProductsViewModel = hiltViewModel()

                        // show own product screen
                        OwnProductsScreen(
                            state = ownProductsViewModel.ownProductsState.value,
                            onDelete = {
                                product -> ownProductsViewModel.onEvent(
                                    event = OwnProductsEvent.OnDelete(
                                        data = product
                                    )
                                )
                            },
                            onUpdate = {
                                product -> navController.navigate(
                                    Routes.OwnProductsUpdateRoutes.route + "/${product.productId}"
                                )
                            },
                            updateDeleteProductState = {
                                newState -> ownProductsViewModel.updateDeleteProductState(
                                    state = newState
                                )
                            },
                            deleteProductState = ownProductsViewModel.deleteOwnProductsState.value,
                            refreshState = ownProductsViewModel.refreshState,
                            onRefresh = {
                                ownProductsViewModel.onRefresh()
                            }
                        )
                    }

                    // create route for own product update
                    composable(
                        route = Routes.OwnProductsUpdateRoutes.route + "/{productId}",
                        arguments = listOf(navArgument("productId") { type = NavType.StringType })
                    ) {
                        // create own products update view model
                        val ownProductsUpdateViewModel : OwnProductsUpdateViewModel = hiltViewModel()

                        // show own products update screen
                        OwnProductsUpdateScreen(
                            initialState = ownProductsUpdateViewModel.initOwnProductsUpdateState.value,
                            updateState = ownProductsUpdateViewModel.updateProductState.value,
                            onEvent = {
                                event -> ownProductsUpdateViewModel.onEvent(
                                    event = event
                                )
                            },
                            changeUpdateState = {
                                state -> ownProductsUpdateViewModel.changeUpdateProductState(
                                    state
                                )
                            }
                        )
                    }

                    // create route for product detail
                    composable(
                        route = Routes.ProductDetailRoutes.route + "/{productId}",
                        arguments = listOf(navArgument(name = "productId"){type = NavType.StringType})
                    ) {
                        // create product detail view model
                        val productDetailViewModel : ProductDetailViewModel = hiltViewModel()

                        // show product detail screen
                        ProductDetailScreen(
                            state = productDetailViewModel.productDataDetail.value
                        )
                    }

                    // create route for cart
                    composable(
                        route = Routes.CartRoutes.route
                    ) {
                        // create cart view model
                        val cartViewModel : CartViewModel = hiltViewModel()

                        // show cart screen
                        CartScreen(
                            state = cartViewModel.cartState.value,
                            isRefresh = cartViewModel.isRefresh,
                            onRefresh = {
                                cartViewModel.onRefresh()
                            },
                            onEvent = {
                                event -> cartViewModel.onEvent(event)
                            },
                            cartEventState = cartViewModel.cartEventState.value,
                            updateCartEventState = {
                                state -> cartViewModel.updateCartEventState(state)
                            }
                        )
                    }

                    // create route for order
                    composable(
                        route = Routes.OrderRoutes.route
                    ) {
                        // create order view model
                        val orderViewModel : OrderViewModel = hiltViewModel()

                        // show order screen
                        OrderMainScreen(
                            state = orderViewModel.orderLocalState.value,
                            requestState = orderViewModel.requestOrderLocalState.value,
                            onEvent = {
                                event -> orderViewModel.onEvent(
                                    event = event,
                                )
                            },
                            orderEvent = orderViewModel.orderEventState.value,
                            isOrderRefresh = orderViewModel.orderRefresh,
                            isOrderRequestRefresh = orderViewModel.orderRequestRefresh,
                            onRefreshOrder = {
                                orderViewModel.onRefreshOrder()
                            },
                            onRefreshOrderRequest = {
                                orderViewModel.onRefreshRequestOrder()
                            }
                        )
                    }

                    // create route for history order
                    composable(
                        route = Routes.OrderHistoryRoute.route
                    ) {
                        // create order finished view model
                        val orderFinishedViewModel : OrderFinishedViewModel = hiltViewModel()

                        // show order finished screen
                        FinishedOrderMainScreen(
                            state = orderFinishedViewModel.orderFinishedLocalState.value,
                            requestState = orderFinishedViewModel.requestOrderFinishedLocalState.value
                        )
                    }
                }
            }
        }
    )
}

fun onMoveTab(
    navController: NavController,
    route : String
) {
    navController.navigate(route) {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop= true
        restoreState= true
    }
}