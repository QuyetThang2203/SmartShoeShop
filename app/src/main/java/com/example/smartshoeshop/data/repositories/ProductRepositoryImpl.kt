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

class ProductRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: FirebaseRemoteDataSource,
    private val mapper: ProductMapper
): ProductRepository {

    override fun getProducts(): Flow<List<Product>> {
        return localDataSource.getAllProducts()
            .map { entities -> // flow map dùng để biến đổi toàn bộ dữ liệu
                entities.map { mapper.toDomain(it) } // list map dùng để biến đổi từng phần tử trong danh sách
            }
    }

    override suspend fun fetchAndCacheProducts() {
        withContext(Dispatchers.IO) { // luồng IO chuyên dùng để đọc/ghi dữ liệu như mạng, firebase
            val remoteProducts = remoteDataSource.getProducts() // trả về một danh sách dạng ProductModel
            val entities = remoteProducts.map {mapper.toEntity(mapper.toDomain(it))} // trả về danh sách dạng ProductEntity
            localDataSource.insertProducts(entities) // lưu vào database cục bộ (Room)
        }
    }

    override suspend fun getProductById(id: String): Product? {
        return localDataSource.getProductById(id)?.let{mapper.toDomain(it)}
    }

}