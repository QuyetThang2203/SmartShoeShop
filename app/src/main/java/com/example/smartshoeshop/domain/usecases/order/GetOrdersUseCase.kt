package com.example.smartshoeshop.domain.usecases.order

import com.example.smartshoeshop.domain.entities.Order
import com.example.smartshoeshop.domain.repositories.OrderRepository
import javax.inject.Inject

class GetOrdersUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {
    suspend operator fun invoke(userId: String): List<Order> {
        return orderRepository.getOrdersForUser(userId)
    }
}