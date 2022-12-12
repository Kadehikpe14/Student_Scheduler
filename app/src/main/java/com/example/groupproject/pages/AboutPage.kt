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