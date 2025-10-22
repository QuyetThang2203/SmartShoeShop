package com.example.smartshoeshop.domain.usecases

import com.example.smartshoeshop.domain.entities.UserPreferences
import com.example.smartshoeshop.domain.repositories.UserPreferencesRepository
import javax.inject.Inject

class SaveUserPreferencesUseCase @Inject constructor(
    val userPreferencesRepository: UserPreferencesRepository
){
    suspend operator fun invoke(userPreferences: UserPreferences) {
        userPreferencesRepository.saveUserPreferences(userPreferences)
    }
}
