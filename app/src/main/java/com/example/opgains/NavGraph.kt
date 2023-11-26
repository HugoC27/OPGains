package com.example.opgains

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
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(
                title = "OPGains",
                buttonText = "Start workout!",
                navController = navController
            )
        }
        composable(
            route = Screen.Detail.route
        ) {
            DetailScreen(
                navController = navController
            )
        }
    }
}