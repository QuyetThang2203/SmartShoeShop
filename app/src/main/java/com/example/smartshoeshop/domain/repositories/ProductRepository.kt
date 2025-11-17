package com.example.smartshoeshop.domain.repositories

import com.example.smartshoeshop.domain.entities.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProducts(): Flow<List<Product>>
    suspend fun fetchAndCacheProducts()
    suspend fun getProductById(id: String): Product?
}