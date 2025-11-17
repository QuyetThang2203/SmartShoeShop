package com.example.smartshoeshop.domain.usecases.preferences

import com.example.smartshoeshop.domain.repositories.UserPreferencesRepository
import javax.inject.Inject

class DeleteUserPreferencesUseCase @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository
) {
    suspend operator fun invoke(userId: String) {
        userPreferencesRepository.deleteUserPreferences(userId)
    }
}