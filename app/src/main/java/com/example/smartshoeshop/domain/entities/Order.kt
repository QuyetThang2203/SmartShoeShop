package com.example.smartshoeshop.domain.entities

import java.util.Date

data class Order(
    val id: String,
    val userId: String,
    val products: List<OrderProduct>,
    val totalPrice: Double,
    val status: String,
    val createdAt: Date?
)

data class OrderProduct(
    val productId: String,
    val quantity: Int,
    val size: String
)
