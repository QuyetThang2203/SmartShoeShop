package com.example.smartshoeshop.domain.usecases

import com.example.smartshoeshop.domain.repositories.ProductRepository
import javax.inject.Inject

class FetchProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke() {
        productRepository.fetchAndCacheProducts()
    }
}