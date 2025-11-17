package com.example.smartshoeshop.data.mappers

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class ListStringConverter {
    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val listStringConverter = moshi.adapter<List<String>>(
        Types.newParameterizedType(
            List::class.java,
            String::class.java
        )
    )

    @TypeConverter
    fun fromString(value: String?): List<String>? {
        return value?.let {listStringConverter.fromJson(it)}
    }

    @TypeConverter
    fun toString(list: List<String>?): String? {
        return list?.let { listStringConverter.toJson(it)}
    }

}