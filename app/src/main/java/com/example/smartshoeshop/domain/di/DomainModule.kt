package com.example.smartshoeshop.domain.di
import com.example.smartshoeshop.domain.repositories.AuthRepository
import com.example.smartshoeshop.domain.repositories.CartRepository
import com.example.smartshoeshop.domain.repositories.OrderRepository
import com.example.smartshoeshop.domain.repositories.ProductRepository
import com.example.smartshoeshop.domain.repositories.StorageRepository
import com.example.smartshoeshop.domain.repositories.UserPreferencesRepository
import com.example.smartshoeshop.domain.usecases.auth.GetCurrentUserIdUseCase
import com.example.smartshoeshop.domain.usecases.auth.LoginWithEmailUseCase
import com.example.smartshoeshop.domain.usecases.auth.LoginWithGoogleUseCase
import com.example.smartshoeshop.domain.usecases.auth.LogoutUseCase
import com.example.smartshoeshop.domain.usecases.auth.RegisterWithEmailUseCase
import com.example.smartshoeshop.domain.usecases.cart.AddCartItemUseCase
import com.example.smartshoeshop.domain.usecases.cart.DeleteAllCartItemsUseCase
import com.example.smartshoeshop.domain.usecases.cart.DeleteCartItemUseCase
import com.example.smartshoeshop.domain.usecases.cart.GetCartItemByIdUseCase
import com.example.smartshoeshop.domain.usecases.cart.GetCartItemsUseCase
import com.example.smartshoeshop.domain.usecases.order.AddOrderUseCase
import com.example.smartshoeshop.domain.usecases.order.GetOrdersUseCase
import com.example.smartshoeshop.domain.usecases.preferences.DeleteUserPreferencesUseCase
import com.example.smartshoeshop.domain.usecases.preferences.GetUserPreferencesUseCase
import com.example.smartshoeshop.domain.usecases.preferences.SaveUserPreferencesUseCase
import com.example.smartshoeshop.domain.usecases.product.FetchProductsUseCase
import com.example.smartshoeshop.domain.usecases.product.GetProductByIdUseCase
import com.example.smartshoeshop.domain.usecases.product.GetProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
Giải thích về Hilt:

- Hilt là một framework của Google dùng cho Dependency Injection trong Android.
- Hilt giúp tự động tạo và cung cấp các dependency mà không phải tự new từng object.
- Hilt quản lý vòng đời của dependency, ví dụ Singleton, Activity-scoped, ViewModel-scoped.
- Khi bạn đánh dấu class với @Inject constructor(), Hilt biết cách tạo instance.
- Khi bạn dùng @Provides trong module, Hilt biết cách tạo dependency nếu cần thêm logic tạo instance.
- Dependency = thứ mà class cần để hoạt động (ở đây ProductRepository là dependency của GetProductsUseCase)
*/

@Module // Báo Hilt rằng đây là module cung cấp dependency (phụ thuộc)
// Module = nơi Hilt biết cách tạo các object cần thiết cho app
@InstallIn(SingletonComponent::class)
// Scope Singleton: các dependency trong module này sống suốt vòng đời app
class DomainModule {

    // Hàm cung cấp GetProductsUseCase cho Hilt
    @Provides // Cho Hilt biết hàm này sẽ cung cấp một dependency
    @Singleton // Hilt chỉ tạo 1 instance duy nhất của GetProductsUseCase
    fun provideGetProductsUseCase(
        productRepository: ProductRepository // Đây là dependency (phụ thuộc)
        // GetProductsUseCase cần ProductRepository để hoạt động
        // Hilt sẽ tự động inject ProductRepository nếu đã được cung cấp ở đâu đó
    ): GetProductsUseCase {
        return GetProductsUseCase(productRepository)
        // Tạo instance của UseCase với dependency đã được inject
    }

    @Provides
    @Singleton
    fun provideFetchProductsUseCase(repository: ProductRepository): FetchProductsUseCase {
        return FetchProductsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetProductByIdUseCase(productRepository: ProductRepository): GetProductByIdUseCase {
        return GetProductByIdUseCase(productRepository)
    }

    @Provides
    @Singleton
    fun provideGetUserPreferencesUseCase(repository: UserPreferencesRepository): GetUserPreferencesUseCase {
        return GetUserPreferencesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSaveUserPreferencesUseCase(repository: UserPreferencesRepository): SaveUserPreferencesUseCase {
        return SaveUserPreferencesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideDeleteUserPreferencesUseCase(repository: UserPreferencesRepository): DeleteUserPreferencesUseCase {
        return DeleteUserPreferencesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetCartItemsUseCase(repository: CartRepository): GetCartItemsUseCase {
        return GetCartItemsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetCartItemByIdUseCase(repository: CartRepository): GetCartItemByIdUseCase {
        return GetCartItemByIdUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAddCartItemUseCase(repository: CartRepository): AddCartItemUseCase {
        return AddCartItemUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideDeleteCartItemUseCase(repository: CartRepository): DeleteCartItemUseCase {
        return DeleteCartItemUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideDeleteAllCartItemsUseCase(repository: CartRepository): DeleteAllCartItemsUseCase {
        return DeleteAllCartItemsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideRegisterWithEmailUseCase(repository: AuthRepository): RegisterWithEmailUseCase {
        return RegisterWithEmailUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideLoginWithEmailUseCase(repository: AuthRepository): LoginWithEmailUseCase {
        return LoginWithEmailUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideLoginWithGoogleUseCase(repository: AuthRepository): LoginWithGoogleUseCase {
        return LoginWithGoogleUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideLogoutUseCase(repository: AuthRepository): LogoutUseCase {
        return LogoutUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetCurrentUserIdUseCase(repository: AuthRepository): GetCurrentUserIdUseCase {
        return GetCurrentUserIdUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAddOrderUseCase(repository: OrderRepository): AddOrderUseCase {
        return AddOrderUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetOrdersUseCase(repository: OrderRepository): GetOrdersUseCase {
        return GetOrdersUseCase(repository)
    }
}







