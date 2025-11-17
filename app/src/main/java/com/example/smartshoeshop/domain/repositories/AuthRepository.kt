package com.example.smartshoeshop.domain.repositories

interface AuthRepository {
    suspend fun registerWithEmail(email: String, password: String): String?
    suspend fun loginWithEmail(email: String, password: String): String?
    suspend fun loginWithGoogle(idToken: String): String?
    fun logout()
    fun getCurrentUserId(): String?
}