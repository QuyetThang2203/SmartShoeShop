package com.example.smartshoeshop.data.repositories

import android.net.Uri
import com.example.smartshoeshop.data.remote.FirebaseRemoteDataSource
import com.example.smartshoeshop.domain.repositories.StorageRepository
import javax.inject.Inject

class StorageRepositoryImpl @Inject constructor(
    private val remoteDataSource: FirebaseRemoteDataSource,

): StorageRepository {
    override suspend fun uploadImage(uri: Uri): String? {
        return remoteDataSource.uploadImage(uri)
    }
}