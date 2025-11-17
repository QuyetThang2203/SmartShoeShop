package com.example.smartshoeshop.data.local

import com.example.smartshoeshop.data.local.dao.CartItemDao
import com.example.smartshoeshop.data.local.dao.ProductDao
import com.example.smartshoeshop.data.local.dao.UserPreferencesDao
import com.example.smartshoeshop.data.local.entities.CartItemEntity
import com.example.smartshoeshop.data.local.entities.ProductEntity
import com.example.smartshoeshop.data.local.entities.UserPreferencesEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val productDao: ProductDao,
    private val userPreferencesDao: UserPreferencesDao,
    private val cartItemDao: CartItemDao,
){
    // Products
    fun getAllProducts(): Flow<List<ProductEntity>> = productDao.getAllProducts()

    suspend fun getProductById(id: String): ProductEntity? = productDao.getProductById(id)

    suspend fun insertProducts(products: List<ProductEntity>) = productDao.insertProducts(products)

    suspend fun insertProduct(product: ProductEntity) = productDao.insertProduct(product)

    suspend fun deleteAllProducts() = productDao.deleteAllProducts()

    // User Preferences
    fun getUserPreferences(userId: String): Flow<UserPreferencesEntity?> = userPreferencesDao.getUserPreferences(userId)

    suspend fun insertUserPreferences(preferences: UserPreferencesEntity) = userPreferencesDao.insertUserPreferences(preferences)

    suspend fun deleteUserPreferences(userId: String) = userPreferencesDao.deleteUserPreferences(userId)

    // Cart Items
    fun getCartItemsForUser(userId: String): Flow<List<CartItemEntity>> = cartItemDao.getCartItemsForUser(userId)

    suspend fun getCartItemById(id: String): CartItemEntity? = cartItemDao.getCartItemById(id)

    suspend fun insertCartItem(cartItem: CartItemEntity) = cartItemDao.insertCartItem(cartItem)

    suspend fun deleteCartItem(id: String) = cartItemDao.deleteCartItem(id)

    suspend fun deleteAllCartItemsForUser(userId: String) = cartItemDao.deleteAllCartItemsForUser(userId)
}
