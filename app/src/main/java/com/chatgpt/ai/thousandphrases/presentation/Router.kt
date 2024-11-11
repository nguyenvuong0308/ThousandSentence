package com.chatgpt.ai.thousandphrases.presentation

import androidx.navigation.NavController

sealed class Router (val route: String) {
    object HomeScreen: Router("home")
    object SearchScreen: Router("search")
}

fun NavController.navigateHome() {
    navigate(Router.HomeScreen.route)
}

fun NavController.navigateSearch() {
    navigate(Router.SearchScreen.route)
}