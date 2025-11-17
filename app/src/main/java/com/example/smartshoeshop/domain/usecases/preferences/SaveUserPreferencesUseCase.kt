package com.example.smartshoeshop.domain.usecases.preferences

import com.example.smartshoeshop.domain.entities.UserPreferences
import com.example.smartshoeshop.domain.repositories.UserPreferencesRepository
import javax.inject.Inject

class SaveUserPreferencesUseCase @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository
) {
    suspend operator fun invoke(preferences: UserPreferences) {
        userPreferencesRepository.saveUserPreferences(preferences)
    }
}