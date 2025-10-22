package com.example.smartshoeshop.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.smartshoeshop.data.local.entities.ProductEntity
import kotlinx.coroutines.flow.Flow

/*
* FLow = luồng dữ liệu sống, lắng nghe liên tục trong database
* suspend = chỉ thực hiện 1 lần, chờ kết quả trả về (dạng đồng bộ bất đồng bộ)
 */
@Dao
interface ProductDao {
    @Query("SELECT * FROM products")
    fun getAllProducts(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM products WHERE id = :id")
    suspend fun getProductById(id: String): ProductEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: ProductEntity)

    @Query("DELETE FROM products")
    suspend fun deleteAllProducts()
}












