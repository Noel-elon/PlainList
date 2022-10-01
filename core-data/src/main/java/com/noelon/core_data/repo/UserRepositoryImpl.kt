package com.noelon.core_data.repo

import com.noelon.core_common.DataState
import com.noelon.core_common.UserModel
import com.noelon.core_data.mapper.toModelList
import com.noelon.core_data.mapper.toUserEntity
import com.noelon.core_database.dao.UserDao
import com.noelon.core_database.entity.UserEntity
import com.noelon.core_network.ApiClient
import com.skydoves.sandwich.message
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient,
    private val userDao: UserDao,
    private val dispatcher: CoroutineDispatcher
) : UserRepository {
    override suspend fun fetchUsers(): Flow<DataState<List<UserModel>>> =
        flow<DataState<List<UserModel>>> {
            val response = apiClient.getUserDetails()
            emit(DataState.data(data = userDao.getAllUsers().toModelList()))

            response.suspendOnSuccess {
                data.results.forEach {
                    saveUserDetails(it.toUserEntity())
                }
                emit(DataState.data(data = userDao.getAllUsers().toModelList()))
            }.suspendOnError {
                emit(DataState.error(message()))
            }
        }.onStart { emit(DataState.loading()) }.flowOn(dispatcher)

    override suspend fun saveUserDetails(userEntity: UserEntity) {
        userDao.saveUserDetails(userEntity)
    }

    override suspend fun fetchUsersByName(name: String): Flow<DataState<List<UserModel>>> =
        flow {
            emit(DataState.data(data = userDao.getCurrentUser(name).toModelList()))
        }.onStart { emit(DataState.loading()) }.flowOn(dispatcher)
}