// Path: app/src/main/java/com/example/smartshoeshop/datastore/preferences/AppPreferencesDataStore.kt
package com.example.smartshoeshop.datastore.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppPreferencesDataStore(private val context: Context) {

    companion object {
        private val USER_ID_KEY = stringPreferencesKey("user_id")
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "app_preferences")
    }

    val userId: Flow<String?> = context.dataStore.data
        .map { preferences -> preferences[USER_ID_KEY] }

    suspend fun saveUserId(userId: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_ID_KEY] = userId
        }
    }

    suspend fun clearUserId() {
        context.dataStore.edit { preferences ->
            preferences.remove(USER_ID_KEY)
        }
    }
}