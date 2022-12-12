package com.example.groupproject.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.groupproject.navigation.Routes
import com.example.groupproject.R
import com.example.groupproject.model.user.UserViewModel

//TODO fix string resources
@Composable
fun LoginPage(
    nav: NavHostController = rememberNavController(),
    uservm: UserViewModel
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ){
        TextRow(text = stringResource(id = R.string.inform_prompt_username))
        FieldRow()
        EmptyRow()
        TextRow(text = stringResource(id = R.string.inform_prompt_password))
        FieldRow()
        EmptyRow()

        Button(onClick = {
            uservm._isLoggedIn.value = true
            nav.navigate(Routes.HomePage.route) {
                popUpTo(Routes.HomePage.route)
                }
            }
        )
        {
            Text("Login", fontSize = 25.sp)
        }

        HyperTextRow(text = stringResource(id = R.string.inform_login_forgotinfo))
        HyperTextRow(text = stringResource(id = R.string.inform_login_signup))
}}
@Composable
fun FieldRow(){
    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp))
    {
        TextField(value = "", onValueChange = {})
    }
}

@Composable
fun TextRow(text: String){
    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp))
    {
        Text(text = text, fontSize = 32.sp)
    }
}

@Composable
fun EmptyRow(){
    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {

    }
}
@Composable
fun HyperTextRow(text: String){
    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp))
    {
        Text(text = text, fontSize = 16.sp, modifier = Modifier.clickable{  })
    }
}

