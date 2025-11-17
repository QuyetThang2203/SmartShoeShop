package com.example.smartshoeshop.data.mappers

import com.example.smartshoeshop.data.local.entities.UserPreferencesEntity
import com.example.smartshoeshop.domain.entities.UserPreferences
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlin.String

class UserPreferencesMapper {
    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val listStringAdapter = moshi.adapter<List<String>>(
        Types.newParameterizedType(List::class.java, String::class.java)
    )

    fun toMain(entity: UserPreferencesEntity): UserPreferences {
        return UserPreferences (
            userId = entity.userId,
            favoriteSizes = listStringAdapter.fromJson(entity.favoriteSizes) ?: emptyList(),
            favoriteCategories = listStringAdapter.fromJson(entity.favoriteCategories) ?: emptyList(),
            favoriteBrands =listStringAdapter.fromJson(entity.favoriteBrands) ?: emptyList()
        )
    }

    fun toEntity(domain: UserPreferences): UserPreferencesEntity {
        return UserPreferencesEntity (
            userId = domain.userId,
            favoriteSizes = listStringAdapter.toJson(domain.favoriteSizes),
            favoriteCategories = listStringAdapter.toJson(domain.favoriteCategories),
            favoriteBrands =listStringAdapter.toJson(domain.favoriteBrands)
        )
    }
}