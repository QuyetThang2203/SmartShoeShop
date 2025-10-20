package com.example.smartshoeshop.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.smartshoeshop.database.dao.CartItemDao
import com.example.smartshoeshop.database.dao.ProductDao
import com.example.smartshoeshop.database.dao.UserPreferencesDao
import com.example.smartshoeshop.database.entity.Product
import com.example.smartshoeshop.database.entity.UserPreferences
import com.example.smartshoeshop.database.entity.CartItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Database(
    entities = [Product::class, UserPreferences::class, CartItem::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ListStringConverter::class)
abstract class AppDatabase(): RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun userPreferencesDao(): UserPreferencesDao
    abstract fun cartItemDao(): CartItemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder (
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
    private val gson = Gson()

    @androidx.room.TypeConverter
    fun fromString(value: String?): List<String>? {
        if(value == null) return null
        val listType = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, listType)
    }

    @androidx.room.TypeConverters
    fun toString(list: List<String>?): String? {
        return gson.toJson(list)
    }
}

















