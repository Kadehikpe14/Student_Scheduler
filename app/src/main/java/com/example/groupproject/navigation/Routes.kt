package com.example.groupproject.navigation

sealed class Routes(val route: String) {
    object HomePage : Routes("home")
    object Login : Routes("login")
    object Settings : Routes("settings")
    object Schedule : Routes("schedule")
    object Todo: Routes("todo")
    object Signup: Routes("signup")
    object Events: Routes("events")
}