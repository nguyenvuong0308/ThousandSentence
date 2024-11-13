package com.chatgpt.ai.thousandphrases.presentation

import androidx.navigation.NavController

sealed class Router (val route: String) {
    object MainScreen: Router("main")
    object HomeScreen: Router("home")
    object SearchScreen: Router("search")
    object VocabularyScreen: Router("vocabulary")
}

fun NavController.navigateHome() {
    navigate(Router.HomeScreen.route)
}

fun NavController.navigateSearch() {
    navigate(Router.SearchScreen.route)
}

fun NavController.navigateVocabulary() {
    navigate(Router.VocabularyScreen.route)
}