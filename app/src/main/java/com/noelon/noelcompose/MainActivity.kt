package com.noelon.noelcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.noelon.noelcompose.navigation.ComposeNavHost
import com.noelon.noelcompose.ui.theme.NoelComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoelComposeTheme {
                NoelComposeApp()
            }
        }
    }
}

@Composable
fun NoelComposeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        ComposeNavHost()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoelComposeTheme {

    }
}