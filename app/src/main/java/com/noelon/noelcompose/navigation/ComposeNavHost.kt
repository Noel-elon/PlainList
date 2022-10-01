package com.noelon.noelcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.noelon.core_navigation.AllScreens
import com.noelon.feature_login.LoginScreen
import com.noelon.feature_search.SearchScreen

@Composable
fun ComposeNavHost(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(navController = navHostController, startDestination = AllScreens.LoginScreen.route) {
        composable(AllScreens.LoginScreen.route) {
            LoginScreen {
                navHostController.navigate(AllScreens.SearchScreen.route)
            }
        }

        composable(AllScreens.SearchScreen.route) {
            SearchScreen()
        }
    }
}