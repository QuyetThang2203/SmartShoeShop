package com.example.smartshoeshop.domain.entities

data class User(
    val id: String,
    val email: String,
    val name: String,
    val preferences: UserPreferences? = null
)
