package com.example.smartshoeshop.domain.entities

data class UserPreferences(
    val userId: String,
    val favoriteSizes: List<String>,
    val favoriteCategories: List<String>,
    val favoriteBrands: List<String>
)
