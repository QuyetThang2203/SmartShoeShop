package com.example.smartshoeshop.data.mappers

import com.example.smartshoeshop.data.local.entities.UserPreferencesEntity
import com.example.smartshoeshop.domain.entities.UserPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UserPreferencesMapper {
    private val gson = Gson()

    fun toDomain(entity: UserPreferencesEntity): UserPreferences {
        return UserPreferences(
            userId = entity.userId,
            favoriteSizes = gson.fromJson(entity.favoriteSizes, object : TypeToken<List<String>>() {}.type) ?: emptyList(),
            favoriteCategories = gson.fromJson(entity.favoriteCategories, object : TypeToken<List<String>>() {}.type) ?: emptyList(),
            favoriteBrands = gson.fromJson(entity.favoriteBrands, object : TypeToken<List<String>>() {}.type) ?: emptyList()
        )
    }

    fun toEntity(domain: UserPreferences): UserPreferencesEntity {
        return UserPreferencesEntity(
            userId = domain.userId,
            favoriteSizes = gson.toJson(domain.favoriteSizes),
            favoriteCategories = gson.toJson(domain.favoriteCategories),
            favoriteBrands = gson.toJson(domain.favoriteBrands)
        )
    }
}