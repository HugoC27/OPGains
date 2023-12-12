package com.example.opgains

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Tracker: Screen(route = "tracker_screen")
    object Contact: Screen(route = "contact_screen")
    object Settings: Screen(route = "settings_screen")
    object VisualizationFront: Screen(route = "visualization_front_screen")
    object VisualizationBack: Screen(route = "visualization_back_screen")
}
