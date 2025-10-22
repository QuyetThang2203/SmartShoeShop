package com.example.smartshoeshop.domain.repositories

import com.example.smartshoeshop.domain.entities.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProducts(): Flow<List<Product>> // Hàm trả về 1 luồng dữ liệu (stream) - theo dõi dữ liệu động, cập nhật tự động
    suspend fun fetchAndCacheProducts()
    suspend fun getProductById(id: String): Product?
}