package com.example.smartshoeshop.domain.usecases.product

import com.example.smartshoeshop.domain.entities.Product
import com.example.smartshoeshop.domain.repositories.ProductRepository
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(
    private val productRepository: ProductRepository
){
    suspend operator fun invoke(id: String): Product? {
        return productRepository.getProductById(id)
    }
}