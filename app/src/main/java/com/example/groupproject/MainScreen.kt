package com.example.groupproject

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.groupproject.navigation.Routes
import com.example.groupproject.navigation.ScheduleNavGraph


@OptIn(ExperimentalComposeUiApi::class,
    ExperimentalFoundationApi::class)
@Composable

//added context for intent in "Home" page
fun MainScreen(
    app: Context
)
{
    val nav = rememberNavController()
    Scaffold(
        topBar = {
            TopBar(nav)
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
fun TopBar(
    nav: NavHostController
){
    TopAppBar(
        title = {
            Row{
                Text("Schedule Maker")
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )
                Icon(Icons.Default.Home,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            nav.navigate(Routes.HomePage.route) {
                                popUpTo(Routes.HomePage.route)
                            }
                        }
                )

            }
        }
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
                Icon(Icons.Default.DateRange, "")
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
                Icon(Icons.Default.List,"")
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
                Icon(Icons.Default.Place, "")
            },
            label = {
                Text("Events")
            })

    }

}