package com.noelon.feature_login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginComponent(
    onLoginClicked: () -> Unit
) {
    var emailText by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(value = emailText, onValueChange = {
            emailText = it
        }, label = { Text(text = "Email") },
            shape = RoundedCornerShape(6.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = password, onValueChange = {
            password = it
        }, label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            shape = RoundedCornerShape(6.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { onLoginClicked() }, colors = textButtonColors(), content = {
            ProvideTextStyle(value = MaterialTheme.typography.button) {
                Text(text = "Login")
            }
        }, shape = RoundedCornerShape(6.dp), modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(2f)
            .padding(start = 0.dp, end = 0.dp, top = 0.dp, bottom = 6.dp)
        )

    }
}

@Composable
fun textButtonColors(
    containerColor: Color = Color.Black,
    contentColor: Color = Color.White,
    disabledContentColor: Color = Color.Gray
) = ButtonDefaults.textButtonColors(
    backgroundColor = containerColor,
    contentColor = contentColor,
    disabledContentColor = disabledContentColor
)

@Preview
@Composable
fun Prev() {
    LoginComponent {

    }
}