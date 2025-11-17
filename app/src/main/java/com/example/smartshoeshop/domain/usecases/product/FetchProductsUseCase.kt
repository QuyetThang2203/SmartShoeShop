package com.example.smartshoeshop.domain.usecases.product

import com.example.smartshoeshop.domain.repositories.ProductRepository
import javax.inject.Inject

/**
 * Đây là UseCase để lấy dữ liệu sản phẩm từ repository và lưu vào cache.
 *
 * Sử dụng `operator fun invoke()` giúp chúng ta gọi UseCase như một hàm:
 *
 *   fetchProductsUseCase()
 *
 * Thay vì phải viết:
 *
 *   fetchProductsUseCase.invoke()
 *
 * `suspend` nghĩa là hàm này chạy trong coroutine, có thể thực hiện công việc bất đồng bộ
 * (ví dụ gọi API, truy vấn database) mà không chặn luồng chính.
 *
 * Đây là convention phổ biến trong Clean Architecture: mỗi UseCase đại diện cho một hành động duy nhất
 * và được gọi giống hàm để code ngắn gọn, trực quan.
 */
class FetchProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
){
    suspend operator fun invoke() {
        productRepository.fetchAndCacheProducts()
    }
}