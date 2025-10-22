package com.example.smartshoeshop.domain.entities

data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val description: String,
    val imageUrl: String,
    val sizeOptions: List<String>,
    val category: String,
    val stock: Int,
    val tags: List<String>
)
