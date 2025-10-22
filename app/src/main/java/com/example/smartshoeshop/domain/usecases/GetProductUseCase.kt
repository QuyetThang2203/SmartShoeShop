package com.example.smartshoeshop.domain.usecases

import com.example.smartshoeshop.domain.entities.Product
import com.example.smartshoeshop.domain.repositories.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/*
* GetProductUseCase là cầu nối giữa ViewModel(ở UI layer) và Repository(ở data layer)
* * Repository chỉ lo lấy dữ liệu(từ Firebase, Room, API,...).
* * Usecase định nghĩa ý nghĩa nghiệp vụ: "Lấy danh sách sản phẩm" là một hành động cụ thể của ứng dụng
*
* operator fun invoke: giúp gọi đối tượng như một hàm
* operator là từ khóa báo cho Kotlin biết hàm này là hàm đặc biệt
*/
class GetProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    operator fun invoke(): Flow<List<Product>> {
        return productRepository.getProducts()
    }
}