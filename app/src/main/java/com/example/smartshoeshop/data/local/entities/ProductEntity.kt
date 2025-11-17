package com.example.smartshoeshop.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val price: Double,
    val description: String,
    val imageUrl: String,
    val sizeOptions: String, // Lưu dưới dạng JSON - Phải parse JSON thành List<String> để dùng
    val category: String,
    val stock: Int,
    val tags: String // Lưu dưới dạng JSON- Phải parse JSON thành List<String> để dùng
)
