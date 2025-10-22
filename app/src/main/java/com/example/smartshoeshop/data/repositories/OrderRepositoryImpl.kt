package com.example.smartshoeshop.data.repositories

import com.example.smartshoeshop.data.mappers.OrderMapper
import com.example.smartshoeshop.data.remote.FirebaseRemoteDataSource
import com.example.smartshoeshop.domain.entities.Order
import com.example.smartshoeshop.domain.repositories.OrderRepository
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val remoteDataSource: FirebaseRemoteDataSource,
    private val mapper: OrderMapper
): OrderRepository {
    override suspend fun addOrder(order: Order): Boolean {
        return remoteDataSource.addOrder(mapper.toModel(order))
    }

    override suspend fun getOrdersForUser(userId: String): List<Order> {
        return remoteDataSource.getOrdersForUser(userId).map { mapper.toDomain(it) }
    }

}