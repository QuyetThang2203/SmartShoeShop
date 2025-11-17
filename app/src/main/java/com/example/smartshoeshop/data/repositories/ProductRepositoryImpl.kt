package com.example.smartshoeshop.data.repositories

import com.example.smartshoeshop.data.local.LocalDataSource
import com.example.smartshoeshop.data.mappers.ProductMapper
import com.example.smartshoeshop.data.remote.FirebaseRemoteDataSource
import com.example.smartshoeshop.domain.entities.Product
import com.example.smartshoeshop.domain.repositories.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

// Đây là class thực hiện việc lấy dữ liệu sản phẩm, nó là phần "Repository" trong Clean Architecture
// Repository này sẽ kết hợp giữa Local (Room) và Remote (Firebase)
class ProductRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: FirebaseRemoteDataSource,
    private val mapper: ProductMapper
) : ProductRepository{ // Thực hiện interface ProductRepository

    override fun getProducts(): Flow<List<Product>> {
        return localDataSource.getAllProducts().map{ entities ->
            // Chuyển từng ProductEntity trong database thành Product (dạng domain)
            entities.map {mapper.toDomain(it)}
        }
    }

    // Lấy dữ liệu từ Firebase và lưu vào Local Database (Room)
    override suspend fun fetchAndCacheProducts() {
        // Chạy trong Dispatchers.IO vì đây là công việc nặng (network + database)
        withContext(Dispatchers.IO) {
            val remoteProducts = remoteDataSource.getProducts() // Lấy dữ liệu từ Firebase
            // Chuyển dữ liệu Firebase (model) -> Domain -> Entity để lưu vào Room
            val entities = remoteProducts.map { mapper.toEntity(mapper.toDomain(it))}
            localDataSource.insertProducts(entities) // Lưu dữ liệu vào local database
        }
    }

    override suspend fun getProductById(id: String): Product? {
        return localDataSource.getProductById(id)?.let { mapper.toDomain(it) }
        // Nếu tìm thấy thì chuyển từ Entity -> Domain, nếu không trả về null
    }

}