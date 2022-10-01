package com.noelon.feature_search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.noelon.core_common.UserModel

@Composable
fun SearchListItem(
    userModel: UserModel
) {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        Text(text = userModel.name, fontSize = 24.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(4.dp))

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Email Address:",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(text = userModel.email, fontSize = 16.sp, color = Color.Black)
        }

        Spacer(modifier = Modifier.height(4.dp))

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Phone number:",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(text = userModel.phoneNumber, fontSize = 16.sp, color = Color.Black)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Divider(
            color = Color.LightGray,
            thickness = 1.dp
        )
    }

}

@Composable
fun SearchListView(items: List<UserModel>) {
    LazyColumn {
        itemsIndexed(items){ index, user ->
            SearchListItem(userModel = user)
        }
    }

}

@Preview("default")
@Composable
private fun ListItemPreview() {
    SearchListItem(
        userModel = UserModel(
            firstName = "Noel",
            lastName = "Nwaelugo",
            address = "",
            image = "",
            phoneNumber = "08070751088",
            email = "noelnwaelugo@gmail.com"
        )
    )
}