package com.example.smartshoeshop.data.remote.models

data class UserModel(
    val id: String = "",
    val email: String = "",
    val name: String = "",
    val preferences: Map<String, List<String>> = mapOf(
        "favorite_sizes" to emptyList(),
        "favorite_categories" to emptyList(),
        "favorite_brands" to emptyList(),
    )
)
