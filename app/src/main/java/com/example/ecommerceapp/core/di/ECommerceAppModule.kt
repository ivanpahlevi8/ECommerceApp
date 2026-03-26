package com.example.ecommerceapp.core.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.ecommerceapp.core.value.Constants
import com.example.ecommerceapp.data.manager.LocalUserManagerImpl
import com.example.ecommerceapp.data.remote.AuthRemoteAPI
import com.example.ecommerceapp.data.remote.CartRemoteAPI
import com.example.ecommerceapp.data.remote.CategoryRemoteAPI
import com.example.ecommerceapp.data.remote.OrderRemoteAPI
import com.example.ecommerceapp.data.remote.ProductRemoteAPI
import com.example.ecommerceapp.data.repositories.AuthRemoteRepositoryImpl
import com.example.ecommerceapp.data.repositories.CartRemoteRepositoryImpl
import com.example.ecommerceapp.data.repositories.CategoryRemoteRepositoryImpl
import com.example.ecommerceapp.data.repositories.OrderRemoteRepositoryImpl
import com.example.ecommerceapp.data.repositories.ProductRemoteRepositoryImpl
import com.example.ecommerceapp.domain.manager.LocalUserManager
import com.example.ecommerceapp.domain.repositories.AuthRemoteRepository
import com.example.ecommerceapp.domain.repositories.CartRemoteRepository
import com.example.ecommerceapp.domain.repositories.CategoryRemoteRepository
import com.example.ecommerceapp.domain.repositories.OrderRemoteRepository
import com.example.ecommerceapp.domain.repositories.ProductRemoteRepository
import com.example.ecommerceapp.domain.usecase.auth_remote_usecase.AuthRemoteUseCase
import com.example.ecommerceapp.domain.usecase.auth_remote_usecase.GetUserProfileUseCase
import com.example.ecommerceapp.domain.usecase.auth_remote_usecase.LoginUserUseCase
import com.example.ecommerceapp.domain.usecase.auth_remote_usecase.RegisterUserUseCase
import com.example.ecommerceapp.domain.usecase.auth_remote_usecase.UpdateUserProfileUseCase
import com.example.ecommerceapp.domain.usecase.cart_remote_usecase.AddCartDetailUseCase
import com.example.ecommerceapp.domain.usecase.cart_remote_usecase.CartRemoteUseCase
import com.example.ecommerceapp.domain.usecase.cart_remote_usecase.ClearCartDetailUseCase
import com.example.ecommerceapp.domain.usecase.cart_remote_usecase.DeleteCartDetailUseCase
import com.example.ecommerceapp.domain.usecase.cart_remote_usecase.DeleteCartHeaderUseCase
import com.example.ecommerceapp.domain.usecase.cart_remote_usecase.GetCartUseCase
import com.example.ecommerceapp.domain.usecase.category_remote_usecase.CategoryRemoteUseCase
import com.example.ecommerceapp.domain.usecase.category_remote_usecase.GetAllCategoryUseCase
import com.example.ecommerceapp.domain.usecase.category_remote_usecase.GetCategoryUseCase
import com.example.ecommerceapp.domain.usecase.local_user_manager_usecase.GetUserLoggedInUseCase
import com.example.ecommerceapp.domain.usecase.local_user_manager_usecase.GetUserOnBoardUseCase
import com.example.ecommerceapp.domain.usecase.local_user_manager_usecase.LocalUserManagerUseCase
import com.example.ecommerceapp.domain.usecase.local_user_manager_usecase.SetUserLogOutUseCase
import com.example.ecommerceapp.domain.usecase.local_user_manager_usecase.SetUserLoginUseCase
import com.example.ecommerceapp.domain.usecase.local_user_manager_usecase.SetUserOnBoardUseCase
import com.example.ecommerceapp.domain.usecase.order_remote_usecase.CreateOrderUseCase
import com.example.ecommerceapp.domain.usecase.order_remote_usecase.GetFinishedOrderUseCase
import com.example.ecommerceapp.domain.usecase.order_remote_usecase.GetFinishedRequestOrderUseCase
import com.example.ecommerceapp.domain.usecase.order_remote_usecase.GetOrderUseCase
import com.example.ecommerceapp.domain.usecase.order_remote_usecase.GetRequestedOrderUseCase
import com.example.ecommerceapp.domain.usecase.order_remote_usecase.OrderRemoteUseCase
import com.example.ecommerceapp.domain.usecase.order_remote_usecase.UpdateOrderUseCase
import com.example.ecommerceapp.domain.usecase.product_remote_usecase.DeleteOwnProductUseCase
import com.example.ecommerceapp.domain.usecase.product_remote_usecase.GetAllProductUseCase
import com.example.ecommerceapp.domain.usecase.product_remote_usecase.GetOnSaleProductUseCase
import com.example.ecommerceapp.domain.usecase.product_remote_usecase.GetOwnProductsUseCase
import com.example.ecommerceapp.domain.usecase.product_remote_usecase.GetProductByIdUseCase
import com.example.ecommerceapp.domain.usecase.product_remote_usecase.InsertProductUseCase
import com.example.ecommerceapp.domain.usecase.product_remote_usecase.ProductRemoteUseCase
import com.example.ecommerceapp.domain.usecase.product_remote_usecase.UpdateProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ECommerceAppModule {
    // provides shared preferences
    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application) : SharedPreferences {
        return application.getSharedPreferences(Constants.AUTH_PREFERENCES, Context.MODE_PRIVATE)
    }

    // provides local user manager
    @Provides
    @Singleton
    fun providesLocalUserManager(application: Application) : LocalUserManager {
        return LocalUserManagerImpl(application)
    }

    // provides local user manager use case
    @Provides
    @Singleton
    fun providesLocalUserManagerUseCase(localUserManager: LocalUserManager) : LocalUserManagerUseCase {
        return LocalUserManagerUseCase(
            getUserOnBoardUseCase = GetUserOnBoardUseCase(
                localUserManager = localUserManager
            ),
            setUserOnBoardUseCase = SetUserOnBoardUseCase(
                localUserManager = localUserManager
            ),
            setUserLoginUseCase = SetUserLoginUseCase(
                localUserManager = localUserManager
            ),
            setUserLogOutUseCase = SetUserLogOutUseCase(
                localUserManager = localUserManager,
            ),
            getUserLoggedInUseCase = GetUserLoggedInUseCase(
                localUserManager = localUserManager
            )
        )
    }

    // provides category remote api
    @Provides
    @Singleton
    fun providesCategoryRemoteApi() : CategoryRemoteAPI {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(180, TimeUnit.SECONDS)
            .readTimeout(180, TimeUnit.SECONDS)
            .writeTimeout(180, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CategoryRemoteAPI::class.java)
    }

    // provides category remote repository
    @Provides
    @Singleton
    fun providesCategoryRemoteRepository(
        categoryRemoteAPI: CategoryRemoteAPI
    ) : CategoryRemoteRepository {
        return CategoryRemoteRepositoryImpl(
            categoryRemoteAPI = categoryRemoteAPI,
        )
    }

    // provides category remote use case
    @Provides
    @Singleton
    fun providesCategoryRemoteUseCase(
        categoryRemoteRepository: CategoryRemoteRepository
    ) : CategoryRemoteUseCase {
        return CategoryRemoteUseCase(
            getAllCategoryUseCase = GetAllCategoryUseCase(
                categoryRemoteRepository = categoryRemoteRepository
            ),
            getCategoryUseCase = GetCategoryUseCase(
                categoryRemoteRepository = categoryRemoteRepository,
            )
        )
    }

    // provides auth remote api
    @Provides
    @Singleton
    fun providesAuthRemoteApi() : AuthRemoteAPI {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(180, TimeUnit.SECONDS)
            .readTimeout(180, TimeUnit.SECONDS)
            .writeTimeout(180, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthRemoteAPI::class.java)
    }

    // provides auth remote repository
    @Provides
    @Singleton
    fun providesAuthRemoteRepository(authRemoteAPI: AuthRemoteAPI) : AuthRemoteRepository {
        return AuthRemoteRepositoryImpl(
            authRemoteAPI = authRemoteAPI
        )
    }

    // provides auth remote use case
    @Provides
    @Singleton
    fun providesAuthRemoteUseCase(
        authRemoteRepository: AuthRemoteRepository,
    ) : AuthRemoteUseCase {
        return AuthRemoteUseCase(
            registerUserUseCase = RegisterUserUseCase(
                authRemoteRepository = authRemoteRepository,
            ),
            loginUserUseCase = LoginUserUseCase(
                authRemoteRepository = authRemoteRepository,
            ),
            getUserUseCase = GetUserProfileUseCase(
                authRemoteRepository = authRemoteRepository,
            ),
            updateUserProfileUseCase = UpdateUserProfileUseCase(
                authRemoteRepository = authRemoteRepository,
            )
        )
    }

    // provides product remote api
    @Provides
    @Singleton
    fun providesProductRemoteApi() : ProductRemoteAPI {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(180, TimeUnit.SECONDS)
            .readTimeout(180, TimeUnit.SECONDS)
            .writeTimeout(180, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductRemoteAPI::class.java)
    }

    // provides product remote repository
    @Provides
    @Singleton
    fun providesProductRemoteRepository(
        productRemoteAPI: ProductRemoteAPI
    ) : ProductRemoteRepository {
        return ProductRemoteRepositoryImpl(
            productRemoteAPI = productRemoteAPI
        )
    }

    // provides product remote use case
    @Provides
    @Singleton
    fun providesProductRemoteUseCase(
        productRemoteRepository: ProductRemoteRepository
    ) : ProductRemoteUseCase {
        return ProductRemoteUseCase(
            getAllProductUseCase = GetAllProductUseCase(
                productRemoteRepository = productRemoteRepository,
            ),
            insertProductUseCase = InsertProductUseCase(
                productRemoteRepository = productRemoteRepository,
            ),
            getOwnProductsUseCase = GetOwnProductsUseCase(
                productRemoteRepository = productRemoteRepository,
            ),
            deleteOwnProductUseCase = DeleteOwnProductUseCase(
                productRemoteRepository = productRemoteRepository,
            ),
            getProductByIdUseCase = GetProductByIdUseCase(
                productRemoteRepository = productRemoteRepository,
            ),
            updateProductUseCase = UpdateProductUseCase(
                productRemoteRepository = productRemoteRepository,
            ),
            getOnSaleProductUseCase = GetOnSaleProductUseCase(
                productRemoteRepository = productRemoteRepository,
            )
        )
    }

    // provides cart remote api
    @Provides
    @Singleton
    fun providesCartRemoteApi() : CartRemoteAPI {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(180, TimeUnit.SECONDS)
            .readTimeout(180, TimeUnit.SECONDS)
            .writeTimeout(180, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CartRemoteAPI::class.java)
    }

    // provides cart remote repository
    @Provides
    @Singleton
    fun providesCartRemoteRepository(
        cartRemoteAPI: CartRemoteAPI,
    ) : CartRemoteRepository {
        return CartRemoteRepositoryImpl(
            cartRemoteAPI = cartRemoteAPI,
        )
    }

    // provides cart remote use case
    @Provides
    @Singleton
    fun providesCartRemoteUseCase(
        cartRemoteRepository: CartRemoteRepository
    ) : CartRemoteUseCase {
        return CartRemoteUseCase(
            getCartUseCase = GetCartUseCase(
                cartRemoteRepository = cartRemoteRepository
            ),
            addCartDetailUseCase = AddCartDetailUseCase(
                cartRemoteRepository = cartRemoteRepository,
            ),
            deleteCartDetailUseCase = DeleteCartDetailUseCase(
                cartRemoteRepository = cartRemoteRepository
            ),
            clearCartDetailUseCase = ClearCartDetailUseCase(
                cartRemoteRepository = cartRemoteRepository
            ),
            deleteCartHeaderUseCase = DeleteCartHeaderUseCase(
                cartRemoteRepository = cartRemoteRepository,
            )
        )
    }

    // provides order remote api
    @Provides
    @Singleton
    fun providesOrderRemoteApi() : OrderRemoteAPI {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(180, TimeUnit.SECONDS)
            .readTimeout(180, TimeUnit.SECONDS)
            .writeTimeout(180, TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OrderRemoteAPI::class.java)
    }

    // provides order remote repository
    @Provides
    @Singleton
    fun providesOrderRemoteRepository(
        orderRemoteApi : OrderRemoteAPI
    ) : OrderRemoteRepository {
        return OrderRemoteRepositoryImpl(
            orderRemoteAPI = orderRemoteApi,
        )
    }

    // provides order remote use case
    @Provides
    @Singleton
    fun providesOrderRemoteUseCase(
        orderRemoteRepository: OrderRemoteRepository
    ) : OrderRemoteUseCase {
        return OrderRemoteUseCase(
            createOrderUseCase = CreateOrderUseCase(
                orderRemoteRepository = orderRemoteRepository
            ),
            getOrderUseCase = GetOrderUseCase(
                orderRemoteRepository = orderRemoteRepository,
            ),
            getRequestedOrderUseCase = GetRequestedOrderUseCase(
                orderRemoteRepository = orderRemoteRepository,
            ),
            updateOrderUseCase = UpdateOrderUseCase(
                orderRemoteRepository = orderRemoteRepository
            ),
            getFinishedOrderUseCase = GetFinishedOrderUseCase(
                orderRemoteRepository = orderRemoteRepository
            ),
            getFinishedRequestOrderUseCase = GetFinishedRequestOrderUseCase(
                orderRemoteRepository = orderRemoteRepository,
            )
        )
    }
}