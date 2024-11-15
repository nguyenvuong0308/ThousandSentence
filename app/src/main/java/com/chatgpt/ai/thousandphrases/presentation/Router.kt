package com.chatgpt.ai.thousandphrases.presentation

import androidx.navigation.NavController
import androidx.navigation.NavType

const val ARG_ROOT_VOCABULARY_ID = "rootVocabularyId"
val ARG_TYPE_ROOT_VOCABULARY_ID = NavType.IntType

sealed class Router (val route: String) {
    object MainScreen: Router("main")
    object HomeScreen: Router("home")
    object SearchScreen: Router("search")
    object VocabularyScreen: Router("vocabulary")
    object AddVocabularyScreen: Router("add vocabulary")
    object DetailVocabularyScreen: Router("detailVocabulary/{$ARG_ROOT_VOCABULARY_ID}") {
        fun createRoute(rootVocabularyId: Int): String = "detailVocabulary/$rootVocabularyId"
    }
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

fun NavController.navigateAddVocabulary() {
    navigate(Router.AddVocabularyScreen.route)
}

fun NavController.navigateDetailVocabulary(rootVocabularyId: Int) {
    navigate(Router.DetailVocabularyScreen.createRoute(rootVocabularyId))
}