package com.noelon.feature_login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
    var isEmailError by rememberSaveable { mutableStateOf(false) }
    var isPasswordError by rememberSaveable { mutableStateOf(false) }

    fun validate(onTextVerified: () -> Unit) {
        isPasswordError = password.length < 6
        isEmailError = !android.util.Patterns.EMAIL_ADDRESS.matcher(emailText).matches()

        if (!isPasswordError && !isEmailError) {
            onTextVerified()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(24.dp))
        Column {

            OutlinedTextField(
                value = emailText,
                onValueChange = {
                    emailText = it
                    isEmailError = false
                },
                label = { Text(text = "Email address") },
                trailingIcon = {
                    if (isEmailError)
                        Icon(Icons.Filled.Info, "error", tint = MaterialTheme.colors.error)
                },
                singleLine = true,
                isError = isEmailError,
                keyboardActions = KeyboardActions { },
            )
            if (isEmailError) {
                Text(
                    text = "Error message",
                    color = MaterialTheme.colors.error,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    isPasswordError = false
                },
                label = { Text(text = "Password") },
                trailingIcon = {
                    if (isPasswordError)
                        Icon(Icons.Filled.Info, "error", tint = MaterialTheme.colors.error)
                },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                isError = isPasswordError,
                shape = RoundedCornerShape(6.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            if (isPasswordError) {
                Text(
                    text = "Error message",
                    color = MaterialTheme.colors.error,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }


        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            validate {
                onLoginClicked()
            }
        }, colors = textButtonColors(), content = {
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