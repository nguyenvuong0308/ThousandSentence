package com.chatgpt.ai.thousandphrases.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.chatgpt.ai.thousandphrases.presentation.ARG_ROOT_VOCABULARY_ID
import com.chatgpt.ai.thousandphrases.presentation.ARG_TYPE_ROOT_VOCABULARY_ID
import com.chatgpt.ai.thousandphrases.presentation.Router
import com.chatgpt.ai.thousandphrases.presentation.home.HomeScreen
import com.chatgpt.ai.thousandphrases.presentation.main.viewmodel.MainViewModel
import com.chatgpt.ai.thousandphrases.presentation.search.SearchScreen
import com.chatgpt.ai.thousandphrases.presentation.addvocabulary.AddVocabularyScreen
import com.chatgpt.ai.thousandphrases.presentation.detailvocabulary.DetailVocabularyScreen
import com.chatgpt.ai.thousandphrases.presentation.vocabulary.VocabularyScreen
import com.example.compose.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val _viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                MyApp()
            }
        }
    }


}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Router.MainScreen.route) {

        composable(Router.MainScreen.route,
            enterTransition = {
                return@composable fadeIn(tween(1000))
            }, exitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            }, popEnterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            }

        ) { MainScreen(navController = navController) }

        composable(Router.HomeScreen.route,
            enterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            }, exitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            }, popEnterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            },
            popExitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            }

        ) { HomeScreen(navController = navController) }

        composable(Router.AddVocabularyScreen.route,
            enterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            }, exitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            }, popEnterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            },
            popExitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            }

        ) { AddVocabularyScreen(navController = navController) }

        composable(Router.SearchScreen.route,

            enterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            },
            popExitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            }
        ) { SearchScreen(navController = navController) }

        composable(Router.VocabularyScreen.route,
            enterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            }, exitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            }, popEnterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            },
            popExitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            }

        ) { VocabularyScreen(navController = navController) }

        composable(
            arguments = listOf(navArgument(ARG_ROOT_VOCABULARY_ID) { type = ARG_TYPE_ROOT_VOCABULARY_ID}),
            route = Router.DetailVocabularyScreen.route,
            enterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            }, exitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            }, popEnterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            },
            popExitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            }

        ) { backStackEntry ->
            val rootVocabularyId = backStackEntry.arguments?.getInt(ARG_ROOT_VOCABULARY_ID)
            DetailVocabularyScreen(navController = navController, rootId = rootVocabularyId ?: 0)
        }
    }
}




