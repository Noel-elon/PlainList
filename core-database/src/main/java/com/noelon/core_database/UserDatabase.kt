package com.noelon.core_database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.noelon.core_database.dao.UserDao
import com.noelon.core_database.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
}