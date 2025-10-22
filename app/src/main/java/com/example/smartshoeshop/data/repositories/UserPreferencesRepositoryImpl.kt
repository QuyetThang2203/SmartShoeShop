package com.example.smartshoeshop.data.repositories

import com.example.smartshoeshop.data.local.LocalDataSource
import com.example.smartshoeshop.data.mappers.UserPreferencesMapper
import com.example.smartshoeshop.domain.entities.UserPreferences
import com.example.smartshoeshop.domain.repositories.UserPreferencesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPreferencesRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val mapper: UserPreferencesMapper
): UserPreferencesRepository {
    override fun getUserPreferences(userId: String): Flow<UserPreferences?> {
        return localDataSource.getUserPreferences(userId).map { it?.let{mapper.toDomain(it)} }
    }

    override suspend fun saveUserPreferences(preferences: UserPreferences) {
        localDataSource.insertUserPreferences(mapper.toEntity(preferences))
    }

    override suspend fun deleteUserPreferences(userId: String) {
        localDataSource.deleteUserPreferences(userId)
    }
}