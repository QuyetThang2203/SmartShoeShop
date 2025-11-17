package com.example.smartshoeshop.data.di

import android.content.Context
import com.example.smartshoeshop.data.local.AppDatabase
import com.example.smartshoeshop.data.local.LocalDataSource
import com.example.smartshoeshop.data.local.dao.CartItemDao
import com.example.smartshoeshop.data.local.dao.ProductDao
import com.example.smartshoeshop.data.local.dao.UserPreferencesDao
import com.example.smartshoeshop.data.mappers.CartItemMapper
import com.example.smartshoeshop.data.mappers.OrderMapper
import com.example.smartshoeshop.data.mappers.ProductMapper
import com.example.smartshoeshop.data.mappers.UserMapper
import com.example.smartshoeshop.data.mappers.UserPreferencesMapper
import com.example.smartshoeshop.data.remote.FirebaseRemoteDataSource
import com.example.smartshoeshop.data.repositories.AuthRepositoryImpl
import com.example.smartshoeshop.data.repositories.CartRepositoryImpl
import com.example.smartshoeshop.data.repositories.OrderRepositoryImpl
import com.example.smartshoeshop.data.repositories.ProductRepositoryImpl
import com.example.smartshoeshop.data.repositories.StorageRepositoryImpl
import com.example.smartshoeshop.data.repositories.UserPreferencesRepositoryImpl
import com.example.smartshoeshop.domain.repositories.AuthRepository
import com.example.smartshoeshop.domain.repositories.CartRepository
import com.example.smartshoeshop.domain.repositories.OrderRepository
import com.example.smartshoeshop.domain.repositories.ProductRepository
import com.example.smartshoeshop.domain.repositories.StorageRepository
import com.example.smartshoeshop.domain.repositories.UserPreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Đây là một Module của Hilt, nơi cung cấp (provide) các đối tượng cần thiết cho app
@Module
// Module này được "cài đặt" vào SingletonComponent -> các đối tượng sẽ tồn tại suốt vòng đời app
@InstallIn(SingletonComponent::class)
object DataModule {

    // Hilt sẽ gọi hàm này để tạo AppDatabase
    @Provides
    @Singleton // AppDatabase chỉ tạo một lần duy nhất (singleton)
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        // Hàm getDatabase() trả về instance của Room Database
        return AppDatabase.getDatabase(context)
    }

    // Hilt dùng hàm này để cung cấp ProductDao cho nơi nào cần
    @Provides
    @Singleton // Dao cũng nên dùng chung 1 instance (Room tự đảm bảo nhưng thêm để Hilt đồng bộ)
    fun provideProductDao(appDatabase: AppDatabase): com.example.smartshoeshop.data.local.dao.ProductDao { // Dùng full package name để tránh nhầm lẫn với các ProductDao khác trong project
        // Lấy ProductDao ra từ database
        return appDatabase.productDao()
    }

    @Provides
    @Singleton
    fun provideUserPreferencesDao(appDatabase: AppDatabase): com.example.smartshoeshop.data.local.dao.UserPreferencesDao {
        return appDatabase.userPreferencesDao()
    }

    @Provides
    @Singleton
    fun provideCartItemDao(appDatabase: AppDatabase): com.example.smartshoeshop.data.local.dao.CartItemDao {
        return appDatabase.cartItemDao()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(
        productDao: ProductDao,
        userPreferencesDao: UserPreferencesDao,
        cartItemDao: CartItemDao
    ): LocalDataSource {
        return LocalDataSource(productDao, userPreferencesDao, cartItemDao)
    }

    @Provides
    @Singleton
    fun provideFirebaseRemoteDataSource(): FirebaseRemoteDataSource {
        return FirebaseRemoteDataSource()
    }

    @Provides
    @Singleton
    fun provideProductMapper(): ProductMapper {
        return ProductMapper()
    }

    @Provides
    @Singleton
    fun provideUserPreferencesMapper(): UserPreferencesMapper {
        return UserPreferencesMapper()
    }

    @Provides
    @Singleton
    fun provideCartItemMapper(): CartItemMapper {
        return CartItemMapper()
    }

    @Provides
    @Singleton
    fun provideUserMapper(): UserMapper {
        return UserMapper()
    }

    @Provides
    @Singleton
    fun provideOrderMapper(): OrderMapper {
        return OrderMapper()
    }

    @Provides
    @Singleton
    fun provideProductRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: FirebaseRemoteDataSource,
        mapper: ProductMapper
    ): ProductRepository {
        return ProductRepositoryImpl(localDataSource, remoteDataSource, mapper)
    }

    @Provides
    @Singleton
    fun provideUserPreferencesRepository(
        localDataSource: LocalDataSource,
        mapper: UserPreferencesMapper
    ): UserPreferencesRepository {
        return UserPreferencesRepositoryImpl(localDataSource, mapper)
    }

    @Provides
    @Singleton
    fun provideCartRepository(
        localDataSource: LocalDataSource,
        mapper: CartItemMapper
    ): CartRepository {
        return CartRepositoryImpl(localDataSource, mapper)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(
        remoteDataSource: FirebaseRemoteDataSource
    ): AuthRepository {
        return AuthRepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideOrderRepository(
        remoteDataSource: FirebaseRemoteDataSource,
        mapper: OrderMapper
    ): OrderRepository {
        return OrderRepositoryImpl(remoteDataSource, mapper)
    }

    @Provides
    @Singleton
    fun provideStorageRepository(
        remoteDataSource: FirebaseRemoteDataSource
    ): StorageRepository {
        return StorageRepositoryImpl(remoteDataSource)
    }
}