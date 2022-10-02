package com.noelon.feature_search.ui

import com.noelon.core_data.repo.UserRepository
import com.noelon.feature_search.SearchViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class SearchViewModelTest {

    private lateinit var underTest: SearchViewModel
    private val userRepo = mockk<UserRepository>()
    private val dispatcher: TestDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        underTest = SearchViewModel(dispatcher = dispatcher, repository = userRepo)
    }

    @Test
    fun `verify necessary methods are called when fetchUser is triggered`() {
        runTest {
            coEvery {
                userRepo.fetchUsers()
            } returns flowOf()

            underTest.fetchUsers()

            coVerify {
                userRepo.fetchUsers()
            }
        }

    }

    @Test
    fun `verify necessary methods are called when fetchUserByName is triggered`() {
        runTest {
            coEvery {
                userRepo.fetchUsersByName(any())
            } returns flowOf()

            underTest.fetchUsersByName("Noel")

            coVerify {
                userRepo.fetchUsersByName(any())
            }
        }

    }
}