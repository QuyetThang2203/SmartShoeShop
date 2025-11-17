package com.example.smartshoeshop.domain.usecases.auth

import com.example.smartshoeshop.domain.repositories.AuthRepository
import javax.inject.Inject

class LoginWithGoogleUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(idToken: String): String? {
        return authRepository.loginWithGoogle(idToken)
    }
}