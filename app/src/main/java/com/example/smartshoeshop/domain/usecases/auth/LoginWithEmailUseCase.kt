package com.example.smartshoeshop.domain.usecases.auth

import com.example.smartshoeshop.domain.repositories.AuthRepository
import com.example.smartshoeshop.domain.repositories.CartRepository
import javax.inject.Inject

class LoginWithEmailUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): String? {
        return authRepository.loginWithEmail(email, password)
    }
}