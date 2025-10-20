package com.example.smartshoeshop.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_preferences")
data class UserPreferences (
    @PrimaryKey
    val user_id: String,
    val favourite_sizes: String,
    val favourite_categories: String,
    val favourite_brands: String
)