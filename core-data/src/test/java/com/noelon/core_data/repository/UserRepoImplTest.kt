package com.noelon.core_data.repository

import com.noelon.core_data.repo.UserRepositoryImpl
import com.noelon.core_database.dao.UserDao
import com.noelon.core_database.entity.UserEntity
import com.noelon.core_network.ApiClient
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class UserRepoImplTest {

    private lateinit var underTest: UserRepositoryImpl
    private val userDao = mockk<UserDao>()
    private val client = mockk<ApiClient>()
    private val dispatcher: TestDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        underTest = UserRepositoryImpl(apiClient = client, userDao = userDao, dispatcher)
    }

    @Test
    fun `verify user data is saved in database`() {
        runTest {
            coEvery {
                userDao.saveUserDetails(any())
            } returns Unit

            underTest.saveUserDetails(
                UserEntity(
                    "Noel",
                    "Noe",
                    "my home",
                    "",
                    "09098877666",
                    "noel@gmail.com"
                )
            )

            coVerify {
                userDao.saveUserDetails(any())
            }
        }

    }

    @Test
    fun `verify filtered user data is retrieved from database`() {
        runTest {
            coEvery {
                userDao.getUserByName(any())
            } returns listOf()

            underTest.fetchUsersByName("Noel").collect()

            coVerify {
                userDao.getUserByName(any())
            }
        }

    }
}