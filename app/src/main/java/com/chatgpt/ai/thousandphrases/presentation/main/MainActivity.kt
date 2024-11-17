package com.chatgpt.ai.thousandphrases.presentation.main

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                MyApp()
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
                intent.data = Uri.parse(("package:" + applicationContext.packageName))
                val manageStorageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    // Handle the result
                    if (Environment.isExternalStorageManager()) {
                        Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                    }
                }
                manageStorageLauncher.launch(intent)
            }

        } else {
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                val permission = registerForActivityResult(contract = ActivityResultContracts.RequestPermission()) {
                    if (it) {
                        Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                    }
                }
                permission.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
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




