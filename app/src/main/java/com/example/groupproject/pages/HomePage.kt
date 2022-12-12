package com.example.groupproject.pages

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.groupproject.R
import com.example.groupproject.model.user.UserViewModel
import com.example.groupproject.navigation.Routes

@Composable
fun HomePage(
    nav: NavHostController = rememberNavController(),
    app: Context,
    uservm: UserViewModel
){
    Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)){
        Row(horizontalArrangement = Arrangement.Center,modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(64.dp))
        }

        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 24.dp)
                .fillMaxWidth())
        { Text("Welcome " +  uservm._username.value + "!", fontSize = 28.sp) }
        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 24.dp)
                .fillMaxWidth())
        { Text(uservm._tuid.value, fontSize = 28.sp) }

        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 24.dp)
                .fillMaxWidth()){
            Button(onClick = {
                nav.navigate(Routes.Settings.route) {
                    popUpTo(Routes.Settings.route)
                } })
            { Text(text = stringResource(id = R.string.title_activity_settings)) }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()){
            Button(onClick = {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://mytu.towson.edu/mytu/home")
                app.startActivity(intent)
            }){
                Text(text = stringResource(id = R.string.mytu))
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()){
            Button(onClick = {
                uservm.logoutUser()
                nav.navigate(Routes.Login.route) {
                    popUpTo(Routes.Login.route)
                } })
            { Text(text = stringResource(id = R.string.logout)) }

            
        }

    }
}