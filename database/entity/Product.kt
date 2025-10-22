package com.example.smartshoeshop.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product (
    @PrimaryKey
    val id: String,
    val name: String,
    val price: Double,
    val description: String,
    val image_url: String,
    val size_options: String,
    val category: String,
    val stock: Int,
    val tags: String
)