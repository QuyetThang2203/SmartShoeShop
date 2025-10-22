package com.example.smartshoeshop.data.remote.models

import com.google.firebase.Timestamp

data class OrderModel(
    val id: String = "",
    val user_id: String = "",
    val products: List<OrderProductModel> = emptyList(),
    val total_price: Double = 0.0,
    val status: String = "",
    val created_at: Timestamp? = null
)

data class OrderProductModel(
    val product_id: String = "",
    val quantity: Int = 0,
    val size: String = ""
)