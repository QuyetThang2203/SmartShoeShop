// Path: app/src/main/java/com/example/smartshoeshop/data/mappers/CartItemMapper.kt
package com.example.smartshoeshop.data.mappers

import com.example.smartshoeshop.data.local.entities.CartItemEntity
import com.example.smartshoeshop.domain.entities.CartItem

class CartItemMapper {

    fun toDomain(entity: CartItemEntity): CartItem {
        return CartItem(
            id = entity.id,
            userId = entity.userId,
            productId = entity.productId,
            quantity = entity.quantity,
            size = entity.size
        )
    }

    fun toEntity(domain: CartItem): CartItemEntity {
        return CartItemEntity(
            id = domain.id,
            userId = domain.userId,
            productId = domain.productId,
            quantity = domain.quantity,
            size = domain.size
        )
    }
}