// Path: app/src/main/java/com/example/smartshoeshop/datastore/di/DataStoreModule.kt
package com.example.smartshoeshop.datastore.di

import android.content.Context
import com.example.smartshoeshop.datastore.preferences.AppPreferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideAppPreferencesDataStore(@ApplicationContext context: Context): AppPreferencesDataStore {
        return AppPreferencesDataStore(context)
    }
}