package com.example.smartshoeshop.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_preferences")
data class UserPreferencesEntity(
    @PrimaryKey
    val userId: String,
    val favoriteSizes: String, // Serialized List<String> as JSON
    val favoriteCategories: String, // Serialized List<String> as JSON
    val favoriteBrands: String, // Serialized List<String> as JSON
)
