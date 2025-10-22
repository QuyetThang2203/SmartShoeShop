package com.example.smartshoeshop.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "cart_items",
    foreignKeys = [ForeignKey(
        entity = ProductEntity::class,
        parentColumns = ["id"],
        childColumns = ["productId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class CartItemEntity(
    @PrimaryKey
    val id: String,
    val userId: String,
    val productId: String,
    val quantity: Int,
    val size: String
)
