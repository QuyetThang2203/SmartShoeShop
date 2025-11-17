package com.example.smartshoeshop.domain.usecases.order

import com.example.smartshoeshop.domain.entities.Order
import com.example.smartshoeshop.domain.repositories.OrderRepository
import javax.inject.Inject

class AddOrderUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {
    suspend operator fun invoke(order: Order): Boolean {
        return orderRepository.addOrder(order)
    }
}