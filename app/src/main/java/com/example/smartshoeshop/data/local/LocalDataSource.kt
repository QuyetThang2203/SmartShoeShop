package com.example.smartshoeshop.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.smartshoeshop.data.local.dao.CartItemDao
import com.example.smartshoeshop.data.local.dao.ProductDao
import com.example.smartshoeshop.data.local.dao.UserPreferencesDao
import com.example.smartshoeshop.data.local.entities.CartItemEntity
import com.example.smartshoeshop.data.local.entities.ProductEntity
import com.example.smartshoeshop.data.local.entities.UserPreferencesEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/*
* Mục đích của LocalDataSource:
* * Là lớp trung gian giữa Repository và Database(DAO)
* * Nó gom tất cả các thao tác Database lại một nơi, để Repository chỉ việc gọi
 */

class LocalDataSource @Inject constructor( // dùng @Inject để Hilt tự động cấp đối tượng, khỏi khởi tạo thủ công
    private val productDao: ProductDao,
    private val cartItemDao: CartItemDao,
    private val userPreferencesDao: UserPreferencesDao
){
    //products
    fun getAllProducts(): Flow<List<ProductEntity>> = productDao.getAllProducts()

    suspend fun getProductById(id: String): ProductEntity? = productDao.getProductById(id)

    suspend fun insertProducts(products: List<ProductEntity>) = productDao.insertProducts(products)

    suspend fun insertProduct(product: ProductEntity) = productDao.insertProduct(product)

    suspend fun deleteAllProducts() = productDao.deleteAllProducts()

    //user preferences
    fun getUserPreferences(userId: String): Flow<UserPreferencesEntity> = userPreferencesDao.getUserPreferences(userId)

    suspend fun insertUserPreferences(userPreferences: UserPreferencesEntity) = userPreferencesDao.insertUserPreferences(userPreferences)

    suspend fun deleteUserPreferences(userId: String) = userPreferencesDao.deleteUserPreferences(userId)

    //cart items
    fun getCartItemsForUser(userId: String): Flow<List<CartItemEntity>> = cartItemDao.getCartItemsForUser(userId)

    suspend fun getCartItemById(id: String): CartItemEntity? = cartItemDao.getCartItemById(id)

    suspend fun insertCartItem(cartItem: CartItemEntity) = cartItemDao.insertCartItem(cartItem)

    suspend fun deleteCartItemById(id: String) = cartItemDao.deleteCartItemById(id)

    suspend fun deleteAllCartItemsForUser(userId: String) = cartItemDao.deleteAllCartItemsForUser(userId)
}