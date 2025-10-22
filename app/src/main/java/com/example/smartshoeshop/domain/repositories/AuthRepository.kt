package com.example.smartshoeshop.domain.repositories

interface AuthRepository {
    suspend fun registerWithEmail(email: String, password: String): String?
    suspend fun loginWithEmail(email: String, password: String): String?
    suspend fun loginWithGoogle(idToken: String): String?
    fun logOut()
    fun getCurrentUserId(): String?
}