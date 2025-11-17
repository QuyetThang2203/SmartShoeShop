package com.example.smartshoeshop.domain.usecases.product

import com.example.smartshoeshop.domain.entities.Product
import com.example.smartshoeshop.domain.repositories.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Dùng operator `invoke` để có thể gọi use case như một hàm:
 * getProductsUseCase() thay vì getProductsUseCase.invoke().
 */
class GetProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
){
    operator fun invoke(): Flow<List<Product>> {
        return productRepository.getProducts()
    }
}