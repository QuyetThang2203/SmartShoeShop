package com.example.smartshoeshop.data.repositories

import com.example.smartshoeshop.data.local.LocalDataSource
import com.example.smartshoeshop.data.mappers.CartItemMapper
import com.example.smartshoeshop.domain.entities.CartItem
import com.example.smartshoeshop.domain.repositories.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val mapper: CartItemMapper
): CartRepository {
    override fun getCartItemsForUser(userId: String): Flow<List<CartItem>> {
        return localDataSource.getCartItemsForUser(userId).map { entities ->
            entities.map { mapper.toDomain(it)}
        }
    }

    override suspend fun getCartItemById(id: String): CartItem? {
        return localDataSource.getCartItemById(id)?.let {
            mapper.toDomain(it)
        }
    }

    override suspend fun addCartItem(cartItem: CartItem) {
        localDataSource.insertCartItem(mapper.toEntity(cartItem))
    }

    override suspend fun deleteCartItem(id: String) {
        localDataSource.deleteCartItem(id)
    }

    override suspend fun deleteAllCartItemsForUser(userId: String) {
        localDataSource.deleteAllCartItemsForUser(userId)
    }
}