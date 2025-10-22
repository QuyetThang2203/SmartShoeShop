package com.example.smartshoeshop.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.smartshoeshop.data.local.entities.CartItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartItemDao {
    @Query("SELECT * FROM cart_items WHERE userId = :userId")
    fun getCartItemsForUser(userId: String): Flow<List<CartItemEntity>>

    @Query("SELECT * FROM cart_items WHERE id = :id")
    suspend fun getCartItemById(id: String): CartItemEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(cartItem: CartItemEntity)

    @Query("DELETE FROM cart_items WHERE id = :id")
    suspend fun deleteCartItemById(id: String)

    @Query("DELETE FROM cart_items WHERE userId = :userId")
    suspend fun deleteAllCartItemsForUser(userId: String)
}