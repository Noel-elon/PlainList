package com.noelon.feature_search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.noelon.core_common.UserModel

@Composable
fun SearchListItem(
    userModel: UserModel
) {
    Row(modifier = Modifier.wrapContentHeight(), verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(userModel.image)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.user_image_desc),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .height(40.dp)
                .width(40.dp),
            alignment = Alignment.Center

        )

        Column(modifier = Modifier.padding(top = 16.dp)) {
            Text(text = userModel.name, fontSize = 18.sp, color = Color.Black)

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.email_title),
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(
                    text = userModel.email,
                    fontSize = 14.sp,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(end = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.phone_title),
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(text = userModel.phoneNumber, fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(end = 8.dp))
            }

            Spacer(modifier = Modifier.height(8.dp))

            Divider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier.padding(end = 8.dp)
            )
        }
    }

}

@Composable
fun SearchListView(items: List<UserModel>) {
    LazyColumn {
        itemsIndexed(items) { index, user ->
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