package com.example.smartshoeshop.data.mappers

import com.example.smartshoeshop.data.remote.models.OrderModel
import com.example.smartshoeshop.data.remote.models.OrderProductModel
import com.example.smartshoeshop.domain.entities.Order
import com.example.smartshoeshop.domain.entities.OrderProduct

class OrderMapper {

    fun toDomain(model: OrderModel): Order {
        return Order(
            id = model.id,
            userId = model.user_id,
            products = model.products.map { toDomainOrderProduct(it) },
            totalPrice = model.total_price,
            status = model.status,
            createdAt = model.created_at?.toDate()
        )
    }

    fun toModel(domain: Order): OrderModel {
        return OrderModel(
            id = domain.id,
            user_id = domain.userId,
            products = domain.products.map { toModelOrderProduct(it) },
            total_price = domain.totalPrice,
            status = domain.status,
            created_at = domain.createdAt?.let { com.google.firebase.Timestamp(it) }
        )
    }

    private fun toDomainOrderProduct(model: OrderProductModel): OrderProduct {
        return OrderProduct(
            productId = model.product_id,
            quantity = model.quantity,
            size = model.size
        )
    }

    private fun toModelOrderProduct(domain: OrderProduct): OrderProductModel {
        return OrderProductModel(
            product_id = domain.productId,
            quantity = domain.quantity,
            size = domain.size
        )
    }
}