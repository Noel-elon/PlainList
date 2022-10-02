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
import androidx.compose.ui.res.stringResource
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
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.login_title), fontSize = 24.sp)

            Spacer(modifier = Modifier.height(24.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {

                OutlinedTextField(
                    value = emailText,
                    onValueChange = {
                        emailText = it
                        isEmailError = false
                    },
                    label = { Text(text = stringResource(id = R.string.email_address)) },
                    trailingIcon = {
                        if (isEmailError)
                            Icon(
                                Icons.Filled.Info,
                                stringResource(R.string.error),
                                tint = MaterialTheme.colors.error
                            )
                    },
                    singleLine = true,
                    isError = isEmailError,
                    modifier = Modifier.fillMaxWidth()
                )
                if (isEmailError) {
                    Text(
                        text = stringResource(R.string.email_error_msg),
                        color = MaterialTheme.colors.error,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        isPasswordError = false
                    },
                    label = { Text(text = stringResource(R.string.password)) },
                    trailingIcon = {
                        if (isPasswordError)
                            Icon(
                                Icons.Filled.Info,
                                stringResource(R.string.error),
                                tint = MaterialTheme.colors.error
                            )
                    },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    isError = isPasswordError,
                    shape = RoundedCornerShape(6.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth()
                )
                if (isPasswordError) {
                    Text(
                        text = stringResource(id = R.string.pwd_error_msg),
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
                    Text(text = stringResource(id = R.string.login_title))
                }
            }, shape = RoundedCornerShape(6.dp), modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(start = 16.dp, end = 16.dp)
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