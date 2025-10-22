package com.example.smartshoeshop.data.remote.models

// Firebase cần khởi tạo model rỗng để có thể tự động đọc dữ liệu vào đối tượng Kotlin mà không bị
// lỗi khi thiếu field hoặc chưa có dữ liệu
data class ProductModel(
    val id: String = "",
    val name: String = "",
    val price: Double = 0.0,
    val description: String = "",
    val image_url: String = "",
    val size_options: List<String> = emptyList(),
    val category: String = "",
    val stock: Int = 0,
    val tags: List<String> = emptyList()
)
