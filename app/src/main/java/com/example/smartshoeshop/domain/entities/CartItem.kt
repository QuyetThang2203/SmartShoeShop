package com.example.smartshoeshop.domain.entities

data class CartItem (
    val id: String,
    val userId: String,
    val productId: String,
    val quantity: Int,
    val size: String
)