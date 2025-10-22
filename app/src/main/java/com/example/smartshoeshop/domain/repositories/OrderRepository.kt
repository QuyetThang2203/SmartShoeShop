package com.example.smartshoeshop.domain.repositories

import com.example.smartshoeshop.domain.entities.Order

interface OrderRepository {
    suspend fun addOrder(order: Order): Boolean
    suspend fun getOrdersForUser(userId: String): List<Order>
}