package com.example.smartshoeshop.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.smartshoeshop.data.local.entities.UserPreferencesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserPreferencesDao {
    @Query("SELECT * FROM user_preferences WHERE userId = :userId")
    fun getUserPreferences(userId: String): Flow<UserPreferencesEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserPreferences(preferences: UserPreferencesEntity)

    @Query("DELETE FROM user_preferences where userId = :userId")
    suspend fun deleteUserPreferences(userId: String)
}