package com.example.smartshoeshop.data.mappers

import com.example.smartshoeshop.data.local.entities.ProductEntity
import com.example.smartshoeshop.data.remote.models.ProductModel
import com.example.smartshoeshop.domain.entities.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.String

class ProductMapper {
    private val gson = Gson() // Thư viện chuyển đổi dữ liệu giữa JSON <-> Object

    // Chuyển dữ liệu Product từ tầng local(Room) sang tầng domain
    fun toDomain(entity: ProductEntity): Product {
        return Product(
            id = entity.id,
            name = entity.name,
            price = entity.price,
            description = entity.description,
            imageUrl = entity.imageUrl,
            sizeOptions = gson.fromJson(entity.sizeOptions, object : TypeToken<List<String>>() {}.type) ?: emptyList(),
            category = entity.category,
            stock = entity.stock,
            tags = gson.fromJson(entity.tags, object : TypeToken<List<String>>() {}.type) ?: emptyList()
        )
    }

    // Chuyển dữ liệu product từ tầng domain sang tầng local(room)
    fun toEntity(domain: Product): ProductEntity {
        return ProductEntity(
            id = domain.id,
            name = domain.name,
            price = domain.price,
            description = domain.description,
            imageUrl = domain.imageUrl,
            sizeOptions = gson.toJson(domain.sizeOptions),
            category = domain.category,
            stock = domain.stock,
            tags = gson.toJson(domain.tags)
        )
    }

    // Chuyển dữ liệu product từ tầng remote(firebase) sang tầng domain
    fun toDomain(model: ProductModel): Product {
        return Product (
            id = model.id,
            name = model.name,
            price = model.price,
            description = model.description,
            imageUrl = model.image_url,
            sizeOptions = model.size_options,
            category = model.category,
            stock = model.stock,
            tags = model.tags
        )
    }

    // Chuyển dữ liệu product từ tầng domain sang tầng remote(firebase)
    fun toModel(domain: Product): ProductModel {
        return ProductModel(
            id = domain.id,
            name = domain.name,
            price = domain.price,
            description = domain.description,
            image_url = domain.imageUrl,
            size_options = domain.sizeOptions,
            category = domain.category,
            stock = domain.stock,
            tags = domain.tags
        )
    }
}