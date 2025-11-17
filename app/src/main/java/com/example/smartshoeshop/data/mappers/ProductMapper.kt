package com.example.smartshoeshop.data.mappers

import com.example.smartshoeshop.data.local.entities.ProductEntity
import com.example.smartshoeshop.data.remote.models.ProductModel
import com.example.smartshoeshop.domain.entities.Product
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlin.String

class ProductMapper {

    // Tạo một đối tượng Moshi – dùng để chuyển đổi (parse) JSON
    private  val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory()) // Giúp Moshi hiểu data class Kotlin
        .build()

    // Adapter = công cụ chuyên dụng mà Moshi tạo ra để chuyển đổi một kiểu dữ liệu cụ thể.
    // Ở đây adapter này dùng để:
    //  - JSON  → List<String>
    //  - List<String> → JSON
    // nó giúp hai thứ vốn không hiểu nhau có thể chuyển đổi qua lại.
    private val listStringAdapter = moshi.adapter<List<String>>(
        Types.newParameterizedType(
            List::class.java,           // Kiểu dữ liệu bên ngoài: List
            String::class.java)  // Kiểu dữ liệu bên trong List: String
    )

    // product local -> product domain
    fun toDomain(entity: ProductEntity): Product {
        return Product (
            id = entity.id,
            name = entity.name,
            price = entity.price,
            description = entity.description,
            imageUrl = entity.imageUrl,
            sizeOptions = listStringAdapter.fromJson(entity.sizeOptions) ?: emptyList(), // đọc từ Room thành List
            category = entity.category,
            stock = entity.stock,
            tags = listStringAdapter.fromJson(entity.tags) ?: emptyList() // đọc từ Room thành List
        )
    }

    // product domain -> product local
    fun toEntity(product: Product): ProductEntity {
        return ProductEntity (
            id = product.id,
            name = product.name,
            price = product.price,
            description = product.description,
            imageUrl = product.imageUrl,
            sizeOptions = listStringAdapter.toJson(product.sizeOptions), // lưu vào Room
            category = product.category,
            stock = product.stock,
            tags  = listStringAdapter.toJson(product.tags) // lưu vào Room
        )
    }

    // product remote -> product domain
    fun toDomain(model: ProductModel): Product{
        return Product(
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

    // product domain -> product remote
    fun toModel(product: Product): ProductModel {
        return ProductModel(
            id = product.id,
            name = product.name,
            price = product.price,
            description = product.description,
            image_url = product.imageUrl,
            size_options = product.sizeOptions,
            category = product.category,
            stock = product.stock,
            tags = product.tags
        )
    }

}