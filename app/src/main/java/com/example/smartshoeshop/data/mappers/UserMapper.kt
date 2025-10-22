package com.example.smartshoeshop.data.mappers

import com.example.smartshoeshop.data.remote.models.UserModel
import com.example.smartshoeshop.domain.entities.User
import com.example.smartshoeshop.domain.entities.UserPreferences

class UserMapper {

    fun toDomain(model: UserModel): User {
        val preferences = UserPreferences(
            userId = model.id,
            favoriteSizes = model.preferences["favorite_sizes"] ?: emptyList(),
            favoriteCategories = model.preferences["favorite_categories"] ?: emptyList(),
            favoriteBrands = model.preferences["favorite_brands"] ?: emptyList()
        )
        return User(
            id = model.id,
            email = model.email,
            name = model.name,
            preferences = preferences
        )
    }

    fun toModel(domain: User): UserModel {
        val preferencesMap = mapOf(
            "favorite_sizes" to (domain.preferences?.favoriteSizes ?: emptyList()),
            "favorite_categories" to (domain.preferences?.favoriteCategories ?: emptyList()),
            "favorite_brands" to (domain.preferences?.favoriteBrands ?: emptyList())
        )
        return UserModel(
            id = domain.id,
            email = domain.email,
            name = domain.name,
            preferences = preferencesMap
        )
    }
}