package com.example.groupproject

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.groupproject.navigation.Routes
import com.example.groupproject.navigation.ScheduleNavGraph


@OptIn(ExperimentalComposeUiApi::class,
    ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    app: Context
)
{
    val nav = rememberNavController()
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar(nav = nav)
        }
    ){
        ScheduleNavGraph(nav, app)
    }
}
//TODO() Add home screen button to top app bar
@Composable
fun TopBar(){
    TopAppBar(
        title = {Text("Schedule Maker")}
    )
}
@Composable
fun BottomBar(
    nav: NavHostController
){
    val backStateEntry = nav.currentBackStackEntryAsState()
    val currentDest = backStateEntry.value?.destination
    BottomNavigation(){
        BottomNavigationItem(
            selected = currentDest?.route == Routes.Schedule.route,
            onClick = {
                nav.navigate(Routes.Schedule.route){
                    popUpTo(Routes.Schedule.route)
                }
            },
            icon = {
                //TODO change Icon
                Icon(Icons.Default.Home, "")
            },
            label = {
                Text("Schedule")
            }
        )
        BottomNavigationItem(
            selected = currentDest?.route == Routes.Todo.route,
            onClick = {
                nav.navigate(Routes.Todo.route){
                    popUpTo(Routes.Todo.route)
                }
            },
            icon = {
                //TODO change icon
                Icon(Icons.Default.Add, "")
            },
            label = {
                Text("Todo")
            }
        )
        BottomNavigationItem(
            selected = currentDest?.route == Routes.Events.route,
            onClick = { nav.navigate(Routes.Events.route){
                popUpTo(Routes.Events.route)
            }},
            icon = {
                //TODO change icon
                Icon(Icons.Default.Delete, "")
            },
            label = {
                Text("Events")
            })

    }

}