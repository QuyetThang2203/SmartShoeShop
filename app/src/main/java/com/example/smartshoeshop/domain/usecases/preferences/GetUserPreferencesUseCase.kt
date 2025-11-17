package com.example.smartshoeshop.domain.usecases.preferences

import com.example.smartshoeshop.domain.entities.UserPreferences
import com.example.smartshoeshop.domain.repositories.UserPreferencesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserPreferencesUseCase @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository
) {
    operator fun invoke(userId: String): Flow<UserPreferences?> {
        return userPreferencesRepository.getUserPreferences(userId)
    }
}