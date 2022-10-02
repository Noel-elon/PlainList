package com.noelon.feature_search

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.noelon.core_designsystem.Loader

@Composable
fun SearchScreen(
    state: SearchState = rememberSearchState(),
    searchViewModel: SearchViewModel = hiltViewModel()
) {

    val userData by searchViewModel.userState.collectAsState()

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.statusBarsPadding())

            Text(
                text = stringResource(R.string.search),
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 16.dp),
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(16.dp))

            SearchBar(query = state.query, onQueryChange = { state.query = it })

            Spacer(modifier = Modifier.height(16.dp))

            LaunchedEffect(state.query.text) {
                if (state.query.text.isEmpty()) {
                    searchViewModel.fetchUsers()
                }
                searchViewModel.fetchUsersByName("%${state.query.text}%")
            }
            when (userData) {
                is UserUiState.Loading -> {
                }
                is UserUiState.Success -> {
                    state.searchResult = (userData as UserUiState.Success).data
                }
                is UserUiState.Error -> {

                }
                else -> {}
            }

            SearchListView(items = state.searchResult)


        }

    }

}