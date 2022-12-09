package com.example.groupproject.navigation

import androidx.compose.runtime.Composable

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = Routes.
    )
}