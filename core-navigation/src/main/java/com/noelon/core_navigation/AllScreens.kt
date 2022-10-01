package com.noelon.core_navigation

import androidx.navigation.NamedNavArgument

sealed class AllScreens(
    val route : String,
    val arguments : List<NamedNavArgument> = emptyList()
) {
    object LoginScreen : AllScreens("login_screen")
    object SearchScreen : AllScreens("search_screen")

}