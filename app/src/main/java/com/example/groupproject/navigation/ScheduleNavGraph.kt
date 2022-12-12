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
import com.example.groupproject.model.user.UserViewModel
import com.example.groupproject.pages.*
import kotlinx.coroutines.CoroutineScope

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
fun ScheduleNavGraph(
    navController: NavHostController = rememberNavController(),
    app: Context,
    uservm: UserViewModel,
    coroutineScope: CoroutineScope
){
    NavHost(
        navController = navController,
        startDestination = Routes.Login.route
    ){
        composable(Routes.HomePage.route){
            HomePage(navController, app, uservm)
        }
        composable(Routes.About.route){
            AboutPage()
        }
        composable(Routes.Login.route){
            LoginPage(navController,uservm,coroutineScope, app)
        }
        composable(Routes.Signup.route){
            SignupPage(nav = navController, uservm = uservm, app = app, coroutineScope = coroutineScope)
        }
        composable(Routes.Schedule.route){
            val scheduleListViewModel: ScheduleListModel = viewModel()
            val gsvm: GSConfirmViewModel = viewModel()
            SchedulePage(scheduleListViewModel, gsvm, navController, uservm, app, coroutineScope)
        }
        composable(Routes.Events.route){
            EventsPage()
        }
        composable(Routes.Todo.route){
            //todo go back to todopage
            TodoPage()
        }
        composable(Routes.Settings.route){
            SettingsPage()
        }
    }
}