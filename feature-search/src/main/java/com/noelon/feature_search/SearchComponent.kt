package com.noelon.feature_search


import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.noelon.core_common.UserModel

@Stable
class SearchState(
    query: TextFieldValue,
    searchResult: List<UserModel>
) {
    var query by mutableStateOf(query)
    var searchResult by mutableStateOf(searchResult)

}

@Composable
fun rememberSearchState(
    query: TextFieldValue = TextFieldValue(""),
    searchResult: List<UserModel> = emptyList()
): SearchState = SearchState(
    query = query,
    searchResult = searchResult
)

@Composable
fun SearchBar(
    query: TextFieldValue,
    onQueryChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Color.Gray,
        contentColor = Color.Black,
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        Box(Modifier.fillMaxSize()) {
            if (query.text.isEmpty()) {
                SearchHint()
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight()
            ) {
                BasicTextField(
                    value = query,
                    onValueChange = onQueryChange,
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
    }
}

@Composable
private fun SearchHint() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    ) {
        Spacer(Modifier.width(8.dp))
        Text(
            text = "Search by name or username",
            color = Color.Black
        )
    }
}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
private fun SearchBarPreview() {
    SearchBar(
        query = TextFieldValue(""),
        onQueryChange = { }
    )


}