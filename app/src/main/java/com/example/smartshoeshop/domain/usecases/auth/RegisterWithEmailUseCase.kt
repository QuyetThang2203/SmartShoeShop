package com.example.smartshoeshop.domain.usecases.auth

import com.example.smartshoeshop.domain.repositories.AuthRepository
import javax.inject.Inject

class RegisterWithEmailUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): String? {
        return authRepository.registerWithEmail(email, password)
    }
}