package com.example.smartshoeshop.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName ="cart_items",
    foreignKeys = [ForeignKey(
        entity = Product::class, // Assuming Product is another entity defined in your database
        parentColumns = ["id"], // Column in Product that is referenced
        childColumns = ["product_id"], // Column in CartItem that references Product
        onDelete = ForeignKey.CASCADE // Delete cart items if the referenced product is deleted
    )]
)
data class CartItem(
    @PrimaryKey
    val id: String,
    val user_id: String,
    val product_id: String,
    val quantity: Int,
    val size: String
)
