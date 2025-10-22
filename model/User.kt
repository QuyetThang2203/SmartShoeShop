package com.example.smartshoeshop.model

data class User(
    val id: String = "",
    val email: String = "",
    val name: String = "",
    val preferences: Map<String, Any> = mapOf(
        "favorite_sizes" to emptyList<String>(),
        "favorite_categories" to emptyList<String>(),
        "favorite_brands" to emptyList<String>()
    )
)
