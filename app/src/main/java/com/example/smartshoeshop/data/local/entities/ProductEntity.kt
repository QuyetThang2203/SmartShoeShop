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
    val sizeOptions: String, // as JSON: list<sizeOption> -> String
    val category: String,
    val stock: Int,
    val tags: String, // as JSON: list<tags> -> String
)
