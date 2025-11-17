package com.example.smartshoeshop.domain.usecases.auth

import com.example.smartshoeshop.domain.repositories.AuthRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke() {
        authRepository.logout()
    }
}