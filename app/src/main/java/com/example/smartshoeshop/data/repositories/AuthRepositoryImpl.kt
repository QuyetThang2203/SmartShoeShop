package com.example.smartshoeshop.data.repositories

import com.example.smartshoeshop.data.remote.FirebaseRemoteDataSource
import com.example.smartshoeshop.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remoteDataSource: FirebaseRemoteDataSource
): AuthRepository {
    override suspend fun registerWithEmail(email: String, password: String): String? {
        return remoteDataSource.registerWithEmail(email, password)
    }

    override suspend fun loginWithEmail(email: String, password: String): String? {
        return remoteDataSource.loginWithEmail(email, password)
    }

    override suspend fun loginWithGoogle(idToken: String): String? {
        return remoteDataSource.loginWithGoogle(idToken)
    }

    override fun logOut() {
        remoteDataSource.logOut()
    }

    override fun getCurrentUserId(): String? {
        return remoteDataSource.getUserCurrentId()
    }

}