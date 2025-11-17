package com.example.smartshoeshop.data.remote.models

data class ProductModel(
    val id: String = "",
    val name: String = "",
    val price: Double = 0.0,
    val description: String = "",
    val image_url: String = "",
    val size_options: List<String> = emptyList(),
    val category: String = "",
    val stock: Int = 0,
    val tags: List<String> = emptyList()
)