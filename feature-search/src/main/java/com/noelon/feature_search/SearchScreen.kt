package com.noelon.feature_search

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchScreen(
    state: SearchState = rememberSearchState()
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.statusBarsPadding())

            Text(text = "Search", fontSize = 24.sp)

            Spacer(modifier = Modifier.height(16.dp))

            SearchBar(query = state.query, onQueryChange = { state.query = it })

            Spacer(modifier = Modifier.height(16.dp))

            SearchListView(items = state.searchResult)


        }

    }

}