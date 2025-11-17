package com.example.smartshoeshop.domain.usecases.cart

import com.example.smartshoeshop.domain.repositories.CartRepository
import javax.inject.Inject

class DeleteCartItemUseCase @Inject constructor(
    private val cartRepository: CartRepository
){
    suspend operator fun invoke(id: String) {
        cartRepository.deleteCartItem(id)
    }
}