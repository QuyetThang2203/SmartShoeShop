package com.example.smartshoeshop.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.smartshoeshop.database.entity.UserPreferences
import kotlinx.coroutines.flow.Flow

@Dao
interface UserPreferencesDao {
    @Query("SELECT * FROM user_preferences WHERE user_id = :userId")
    fun getUserPreferences(userId: String): Flow<UserPreferences?> // Returns a Flow to observe changes in user preferences

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserPreferences(userPreferences: UserPreferences)

    @Query("DELETE FROM user_preferences WHERE user_id = :userId")
    suspend fun deleteUserPreferences(userId: String)

}