package com.example.opgains

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

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
    ){
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
                trackerButtonText="Visualize",
                navController = navController,
                workoutExercises=0
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
            route = Screen.VisualizationFront.route
        ) {
            VisualizationFrontScreen(
                navController = navController
            )
        }
        composable(
            route = Screen.VisualizationBack.route
        ) {
            VisualizationBackScreen(
                navController = navController
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