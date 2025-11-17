package com.example.smartshoeshop.domain.usecases.cart

import com.example.smartshoeshop.domain.repositories.CartRepository
import javax.inject.Inject

class DeleteAllCartItemsUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke(userId: String) {
        cartRepository.deleteAllCartItemsForUser(userId)
    }
}