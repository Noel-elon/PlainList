package com.noelon.feature_search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noelon.core_common.UserModel
import com.noelon.core_data.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val repository: UserRepository
) : ViewModel() {
    private val _userState = MutableStateFlow<UserUiState?>(null)
    val userState = _userState as StateFlow<UserUiState?>

    init {
        for (i in 1..3) {
            fetchUsers()
        }
    }

     fun fetchUsers() {
        viewModelScope.launch(dispatcher) {
            repository.fetchUsers().collect { state ->
                when {
                    state.isLoading -> {
                        _userState.value = UserUiState.Loading
                    }
                    state.success -> {
                        _userState.value = UserUiState.Success(data = state.data ?: emptyList())
                    }
                    else -> {
                        _userState.value =
                            UserUiState.Error(message = state.message ?: "Something went wrong")
                    }
                }
            }
        }
    }

    fun fetchUsersByName(name: String) {
        viewModelScope.launch(dispatcher) {
            repository.fetchUsersByName(name).collect { state ->
                when {
                    state.isLoading -> {
                        _userState.value = UserUiState.Loading
                    }
                    state.success -> {
                        _userState.value = UserUiState.Success(data = state.data ?: emptyList())
                    }
                    else -> {
                        _userState.value =
                            UserUiState.Error(message = state.message ?: "Something went wrong")
                    }
                }
            }
        }
    }

}

sealed interface UserUiState {
    object Loading : UserUiState
    data class Error(
        val message: String
    ) : UserUiState

    data class Success(
        val data: List<UserModel>
    ) : UserUiState

}