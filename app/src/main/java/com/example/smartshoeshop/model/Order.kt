package com.example.smartshoeshop.model

import com.google.firebase.Timestamp

data class Order(
    val id: String,
    val user_id: String,
    val products: List<OrderProduct> = emptyList(),
    val total_price: Double = 0.0,
    val status: String = "",
    val create_at: Timestamp? = null
)

data class OrderProduct(
    val product_id: String = "",
    val quantity: Int = 0,
    val size: String = ""
)
