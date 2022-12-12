package com.example.groupproject.pages

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun AboutPage(
    nav: NavHostController = rememberNavController()
){
    Text("This is the about page")
}

/*
import android.app.Application
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.AndroidViewModel
import com.example.groupproject.data.UserDatabaseRepo
import com.example.groupproject.model.user.UserViewModel

@Composable
class SignupPage(uservm: UserViewModel, app: Context){

    val userrepo = UserDatabaseRepo(app)
    var username= remember { mutableStateOf("") }
    Column{

    }

 */