// Path: app/src/main/java/com/example/smartshoeshop/data/local/AppDatabase.kt
package com.example.smartshoeshop.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.smartshoeshop.data.local.dao.CartItemDao
import com.example.smartshoeshop.data.local.dao.ProductDao
import com.example.smartshoeshop.data.local.dao.UserPreferencesDao
import com.example.smartshoeshop.data.local.entities.CartItemEntity
import com.example.smartshoeshop.data.local.entities.ProductEntity
import com.example.smartshoeshop.data.local.entities.UserPreferencesEntity
import com.example.smartshoeshop.data.mappers.ListStringConverter

// Khai báo Room Database, gồm các bảng (entities) và version DB.
// exportSchema = false: không cần xuất file schema khi build.
@Database(entities = [ProductEntity::class, UserPreferencesEntity::class, CartItemEntity::class], version = 1, exportSchema = false)

// Sử dụng converter để Room có thể lưu List<String> vào database.
@TypeConverters(ListStringConverter::class)
abstract class AppDatabase : RoomDatabase() {

    // Lấy instance của ProductDao để thao tác bảng sản phẩm.
    abstract fun productDao(): ProductDao
    // Lấy instance của UserPreferencesDao để thao tác bảng cài đặt người dùng.

    abstract fun userPreferencesDao(): UserPreferencesDao

    // Lấy instance của CartItemDao để thao tác bảng giỏ hàng.
    abstract fun cartItemDao(): CartItemDao

    companion object {

        // INSTANCE là biến giữ singleton của database.
        // @Volatile giúp đảm bảo giá trị luôn đồng bộ giữa các thread.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Nếu INSTANCE != null → trả về luôn.
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                // Nếu INSTANCE == null → tạo mới database.
                val instance = Room.databaseBuilder(
                    context.applicationContext,         // tránh leak memory
                    AppDatabase::class.java,     // class database
                    "smart_shoe_shop_database"   // tên file .db được lưu trong device
                ).build()

                // Gán cho INSTANCE để lần sau dùng lại
                INSTANCE = instance

                // Trả về instance vừa tạo
                instance
            }
        }
    }
}