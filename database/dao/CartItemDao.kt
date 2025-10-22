package com.example.smartshoeshop.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.smartshoeshop.database.entity.CartItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CartItemDao {
    @Query("SELECT * FROM cart_items WHERE user_id = :userId")
    fun getCartItemsForUser(userId: String): Flow<List<CartItem>>

    @Query("SELECT * FROM cart_items WHERE id = :id")
    suspend fun getCartItemById(id: String): CartItem?

    // Thêm 1 cart item
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(cartItem: CartItem)

    // Xóa cart item theo id
    @Query("DELETE FROM cart_items WHERE id = :id")
    suspend fun deleteCartItemById(id: String)

    // Xóa cart item theo id_user
    @Query("DELETE FROM cart_items WHERE user_id = :userId")
    suspend fun deleteCartItems(userId: String)
}