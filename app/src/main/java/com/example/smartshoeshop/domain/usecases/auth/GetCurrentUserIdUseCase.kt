package com.example.smartshoeshop.domain.usecases.auth

import com.example.smartshoeshop.domain.repositories.AuthRepository
import javax.inject.Inject

class GetCurrentUserIdUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    fun invoke(): String? {
        return authRepository.getCurrentUserId()
    }
}