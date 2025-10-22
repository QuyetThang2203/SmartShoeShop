package com.example.smartshoeshop.domain.usecases

import com.example.smartshoeshop.domain.entities.UserPreferences
import com.example.smartshoeshop.domain.repositories.UserPreferencesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserPreferencesUseCase @Inject constructor(
    val userPreferencesUseCase: UserPreferencesRepository
){
    operator fun invoke(userId: String): Flow<UserPreferences?> {
        return userPreferencesUseCase.getUserPreferences(userId)
    }
}