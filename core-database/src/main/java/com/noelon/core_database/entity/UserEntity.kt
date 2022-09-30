package com.noelon.core_database.entity

import androidx.room.Entity

@Entity(tableName = "users")
data class UserEntity(
    val firstName: String,
    val lastName: String,
    val address: String,
    val image: String,
    val phoneNumber: String,
    val email: String
)