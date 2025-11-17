package com.example.smartshoeshop.domain.usecases.cart

import com.example.smartshoeshop.domain.entities.CartItem
import com.example.smartshoeshop.domain.repositories.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCartItemsUseCase @Inject constructor(
    private val cartRepository: CartRepository
){
    operator fun invoke(userId: String): Flow<List<CartItem>> {
        return cartRepository.getCartItemsForUser(userId)
    }
}