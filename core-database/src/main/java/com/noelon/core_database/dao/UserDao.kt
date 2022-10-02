package com.noelon.core_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.noelon.core_database.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUserDetails(user: UserEntity)

    @Query(value = "SELECT * FROM users WHERE firstName LIKE :username")
    suspend fun getCurrentUser(username : String) : List<UserEntity>

    @Query(value = "SELECT * FROM users")
    suspend fun getAllUsers() : List<UserEntity>
}