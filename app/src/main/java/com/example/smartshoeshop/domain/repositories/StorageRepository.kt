package com.example.smartshoeshop.domain.repositories

import android.net.Uri

interface StorageRepository {
    suspend fun uploadImage(uri: Uri): String?
}