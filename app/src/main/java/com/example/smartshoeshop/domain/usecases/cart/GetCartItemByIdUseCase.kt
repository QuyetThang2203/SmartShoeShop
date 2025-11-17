package com.example.smartshoeshop.domain.usecases.cart

import com.example.smartshoeshop.domain.entities.CartItem
import com.example.smartshoeshop.domain.repositories.CartRepository
import javax.inject.Inject

class GetCartItemByIdUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke(id: String): CartItem? {
        return cartRepository.getCartItemById(id)
    }
}