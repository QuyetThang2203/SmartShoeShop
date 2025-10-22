package com.example.smartshoeshop.data.local


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.smartshoeshop.data.local.dao.CartItemDao
import com.example.smartshoeshop.data.local.dao.ProductDao
import com.example.smartshoeshop.data.local.dao.UserPreferencesDao
import com.example.smartshoeshop.data.local.entities.CartItemEntity
import com.example.smartshoeshop.data.local.entities.ProductEntity
import com.example.smartshoeshop.data.local.entities.UserPreferencesEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Database(
    entities = [ProductEntity::class, CartItemEntity::class, UserPreferencesEntity::class],
    version = 1
)
@TypeConverters
abstract class AppDatabase(): RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun userPreferencesDao(): UserPreferencesDao
    abstract fun cartItemEntityDao(): CartItemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "smart_shoe_shop_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

class ListStringConverter {
    private val gson = Gson() // Thư viện GSon(Google JSON) dùng để chuyển đổi dữ liệu dạng JSON và Object

    @TypeConverters
    fun fromString(value: String?): List<String>? {
        if(value == null) return null
        val listType = object : TypeToken<List<String>>() {}.type // Với kiểu dữ liệu List<String> thì cần chỉ rõ cho GSon
        return gson.fromJson(value, listType) // ["A","B","C"] -> listOf("A", "B", "C")
    }

    @TypeConverters
    fun toString(list: List<String>): String {
        return gson.toJson(list) // Dùng Gson để chuyển List<String> sang JSON String cho Room lưu trữ
    }
}