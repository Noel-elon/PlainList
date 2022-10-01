package com.noelon.feature_login

import androidx.compose.runtime.Composable

@Composable
fun LoginScreen(
    onLoginClicked: () -> Unit
) {
    LoginComponent {
        onLoginClicked()
    }
}