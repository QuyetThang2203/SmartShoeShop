package com.example.smartshoeshop.repository

import com.example.smartshoeshop.database.entity.Product
import com.example.smartshoeshop.database.AppDatabase
import com.example.smartshoeshop.database.ListStringConverter
import com.example.smartshoeshop.firebase.FirebaseService
import com.example.smartshoeshop.model.Product as ModelProduct
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

data class ProductRepository(private val database: AppDatabase, private val firebaseService: FirebaseService) {
    private val gson = Gson()
    private val converter = ListStringConverter()

    // Fetch from Firebase and cache to Room
    suspend fun fetchAndCacheProducts() {
        withContext(Dispatchers.IO) {
            val remoteProducts = firebaseService.getProducts()
            val localProducts = remoteProducts.map { modelToEntity(it) }
            database.productDao().insertProducts(localProducts)
        }
    }

    // Get products from Room (local cache)
    fun getProducts(): Flow<List<ModelProduct>> {
        return database.productDao()
            .getAllProducts()
            .map { list ->
                list.map{entityToModel(it)}
            }
    }

    // Convert Model to Entity
    private fun modelToEntity(model: ModelProduct): Product {
        return Product(
            id = model.id,
            name = model.name,
            price = model.price,
            description = model.description,
            image_url = model.image_url,
            size_options = gson.toJson(model.size_options),
            category = model.category,
            stock = model.stock,
            tags = gson.toJson(model.tags)
        )
    }

    // Convert Entity to Model
    private fun entityToModel(entity: Product): ModelProduct {
        return ModelProduct (
            id = entity.id,
            name = entity.name,
            price = entity.price,
            description = entity.description,
            image_url = entity.image_url,
            size_options = converter.fromString(entity.size_options) ?: emptyList(),
            category = entity.category,
            stock = entity.stock,
            tags = converter.fromString(entity.tags) ?: emptyList()
        )
    }
}
