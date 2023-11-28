package com.example.opgains

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Detail: Screen(route = "detail_screen")
    object Contact: Screen(route = "contact_screen")
    object Settings: Screen(route = "settings_screen")
}
