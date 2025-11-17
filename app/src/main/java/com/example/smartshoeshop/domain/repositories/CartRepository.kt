package com.example.smartshoeshop.domain.repositories

import com.example.smartshoeshop.domain.entities.CartItem
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    fun getCartItemsForUser(userId: String): Flow<List<CartItem>>
    suspend fun getCartItemById(id: String): CartItem?
    suspend fun addCartItem(cartItem: CartItem)
    suspend fun deleteCartItem(id: String)
    suspend fun deleteAllCartItemsForUser(userId: String)
}