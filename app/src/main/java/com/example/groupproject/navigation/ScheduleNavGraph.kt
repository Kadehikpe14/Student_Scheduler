package com.example.groupproject.navigation

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.groupproject.GenerateScheduleConfirmDialogueBox.GSConfirmViewModel
import com.example.groupproject.model.schedulelist.ScheduleListModel
import com.example.groupproject.pages.*

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun ScheduleNavGraph(
    navController: NavHostController = rememberNavController(),
    app: Context
){
    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ){
        composable(Routes.HomePage.route){
            HomePage(navController, app)
        }
        composable(Routes.About.route){
            AboutPage()
        }
        composable(Routes.Login.route){
            LoginPage(navController)
        }
        composable(Routes.Schedule.route){
            val scheduleListViewModel: ScheduleListModel = viewModel()
            val gsvm: GSConfirmViewModel = viewModel()
            SchedulePage(scheduleListViewModel, gsvm)
        }
        composable(Routes.Events.route){
            EventsPage()
        }
        composable(Routes.Todo.route){
            TodoPage()
        }
    }
}