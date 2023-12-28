package com.example.opgains

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        enterTransition = {
            EnterTransition.None
        },
        exitTransition = {
            ExitTransition.None
        }
    ) {
        composable(
            route = Screen.Home.route,
        ) {
            HomeScreen(
                title = "OPGains",
                buttonText = "START WORKOUT",
                navController = navController
            )
        }
        composable(
            route = Screen.Tracker.route,
        ) {
            TrackerScreen(
                trackerButtonText = "Visualize",
                navController = navController,
                workoutExercises = 0
            )
        }
        composable(
            route = Screen.Contact.route,
        ) {
            ContactScreen(
                navController = navController
            )
        }
        composable(
            route = Screen.Settings.route
        ) {
            SettingsScreen(
                navController = navController
            )
        }
        composable(
            route = Screen.VisualizationFront.route,
            arguments = listOf(
                navArgument(ARGUMENT_CALVES) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_THIGH) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_HIP_ABDUCTOR) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_ABS) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_OBLIQUE) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_LATS) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_CHEST) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_TRAPS) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_NECK) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_SHOULDER) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_TRICEPS) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_BICEPS) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_FOREARMS) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_HAMSTRINGS) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_GLUTES) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_LOWERBACK) {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) {
            VisualizationFrontScreen(
                navController = navController,
                scoreCalves = it.arguments?.getInt(ARGUMENT_CALVES)!!,
                scoreThigh = it.arguments?.getInt(ARGUMENT_THIGH)!!,
                scoreHipAbductor = it.arguments?.getInt(ARGUMENT_HIP_ABDUCTOR)!!,
                scoreAbs = it.arguments?.getInt(ARGUMENT_ABS)!!,
                scoreOblique = it.arguments?.getInt(ARGUMENT_OBLIQUE)!!,
                scoreLats = it.arguments?.getInt(ARGUMENT_LATS)!!,
                scoreChest = it.arguments?.getInt(ARGUMENT_CHEST)!!,
                scoreTraps = it.arguments?.getInt(ARGUMENT_TRAPS)!!,
                scoreNeck = it.arguments?.getInt(ARGUMENT_NECK)!!,
                scoreShoulders = it.arguments?.getInt(ARGUMENT_SHOULDER)!!,
                scoreTriceps = it.arguments?.getInt(ARGUMENT_TRICEPS)!!,
                scoreBiceps = it.arguments?.getInt(ARGUMENT_BICEPS)!!,
                scoreForearms = it.arguments?.getInt(ARGUMENT_FOREARMS)!!,
                scoreHamstrings = it.arguments?.getInt(ARGUMENT_HAMSTRINGS)!!,
                scoreGlutes = it.arguments?.getInt(ARGUMENT_GLUTES)!!,
                scoreLowerBack = it.arguments?.getInt(ARGUMENT_LOWERBACK)!!
            )
        }
        composable(
            route = Screen.VisualizationBack.route,
            arguments = listOf(
                navArgument(ARGUMENT_CALVES) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_THIGH) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_HIP_ABDUCTOR) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_ABS) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_OBLIQUE) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_LATS) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_CHEST) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_TRAPS) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_NECK) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_SHOULDER) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_TRICEPS) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_BICEPS) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_FOREARMS) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_HAMSTRINGS) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_GLUTES) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ARGUMENT_LOWERBACK) {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) {
            VisualizationBackScreen(
                navController = navController,
                scoreCalves = it.arguments?.getInt(ARGUMENT_CALVES)!!,
                scoreThigh = it.arguments?.getInt(ARGUMENT_THIGH)!!,
                scoreHipAbductor = it.arguments?.getInt(ARGUMENT_HIP_ABDUCTOR)!!,
                scoreAbs = it.arguments?.getInt(ARGUMENT_ABS)!!,
                scoreOblique = it.arguments?.getInt(ARGUMENT_OBLIQUE)!!,
                scoreLats = it.arguments?.getInt(ARGUMENT_LATS)!!,
                scoreChest = it.arguments?.getInt(ARGUMENT_CHEST)!!,
                scoreTraps = it.arguments?.getInt(ARGUMENT_TRAPS)!!,
                scoreNeck = it.arguments?.getInt(ARGUMENT_NECK)!!,
                scoreShoulders = it.arguments?.getInt(ARGUMENT_SHOULDER)!!,
                scoreTriceps = it.arguments?.getInt(ARGUMENT_TRICEPS)!!,
                scoreBiceps = it.arguments?.getInt(ARGUMENT_BICEPS)!!,
                scoreForearms = it.arguments?.getInt(ARGUMENT_FOREARMS)!!,
                scoreHamstrings = it.arguments?.getInt(ARGUMENT_HAMSTRINGS)!!,
                scoreGlutes = it.arguments?.getInt(ARGUMENT_GLUTES)!!,
                scoreLowerBack = it.arguments?.getInt(ARGUMENT_LOWERBACK)!!
            )
        }
        composable(
            route = Screen.Exercise.route,
        ) {
            ExerciseScreen(
                navController = navController,
            )
        }
    }
}