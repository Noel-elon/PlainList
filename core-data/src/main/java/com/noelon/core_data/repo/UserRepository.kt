package com.noelon.core_data.repo

import com.noelon.core_common.DataState
import com.noelon.core_common.UserModel
import com.noelon.core_database.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun fetchUsers(): Flow<DataState<List<UserModel>>>

    suspend fun saveUserDetails(userEntity: UserEntity)

    suspend fun fetchUsersByName(name: String): Flow<DataState<List<UserModel>>>
}