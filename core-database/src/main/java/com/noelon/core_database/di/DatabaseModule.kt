package com.noelon.core_database.di

import android.content.Context
import androidx.room.Room
import com.noelon.core_database.dao.UserDao
import com.noelon.core_database.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context): UserDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            UserDatabase::class.java,
            "user-database"
        ).build()

    @Provides
    @Singleton
    fun provideUserDao(userDatabase: UserDatabase): UserDao =
        userDatabase.userDao()
}