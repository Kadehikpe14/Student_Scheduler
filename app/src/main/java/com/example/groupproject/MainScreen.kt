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
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.groupproject.model.user.UserViewModel
import com.example.groupproject.navigation.Routes
import com.example.groupproject.navigation.ScheduleNavGraph
import kotlinx.coroutines.CoroutineScope


@OptIn(ExperimentalComposeUiApi::class,
    ExperimentalFoundationApi::class)
@Composable

//added context for intent in "Home" page
fun MainScreen(
    app: Context,
    uservm: UserViewModel,
    coroutineScope: CoroutineScope
)
{
    val nav = rememberNavController()
    Scaffold(
        topBar = {
            TopBar(nav, uservm)
        },
        bottomBar = {
            if(uservm._isLoggedIn.value == false){

            }
            else {
                BottomBar(nav = nav)
            }
        }
    ){
        ScheduleNavGraph(nav, app, uservm, coroutineScope)
    }
}

@Composable
fun TopBar(
    nav: NavHostController,
    uservm: UserViewModel
){
    TopAppBar(
        title = {
            Row{
                Text(stringResource(id = R.string.app_name))
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )
                if(uservm._isLoggedIn.value == true){
                    Icon(Icons.Default.Home,
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                nav.navigate(Routes.HomePage.route) {
                                    popUpTo(Routes.HomePage.route)
                            }
                        }
                )}

            }
        }
    )
}
//where our main nav elements reside
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
                Icon(Icons.Default.DateRange, "")
            },
            label = {
                Text(stringResource(id = R.string.schedule))
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
                Icon(Icons.Default.List,"")
            },
            label = {
                Text(stringResource(id = R.string.todos))
            }
        )
        BottomNavigationItem(
            selected = currentDest?.route == Routes.Events.route,
            onClick = { nav.navigate(Routes.Events.route){
                popUpTo(Routes.Events.route)
            }},
            icon = {
                Icon(Icons.Default.Place, "")
            },
            label = {
                Text(stringResource(id = R.string.events))
            })

    }

}