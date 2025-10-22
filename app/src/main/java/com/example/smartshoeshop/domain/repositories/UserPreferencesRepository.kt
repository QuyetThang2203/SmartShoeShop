package com.example.smartshoeshop.domain.repositories

import com.example.smartshoeshop.domain.entities.UserPreferences
import kotlinx.coroutines.flow.Flow

interface UserPreferencesRepository {
    fun getUserPreferences(userId: String): Flow<UserPreferences?>
    suspend fun saveUserPreferences(preferences: UserPreferences)
    suspend fun deleteUserPreferences(userId: String)
}