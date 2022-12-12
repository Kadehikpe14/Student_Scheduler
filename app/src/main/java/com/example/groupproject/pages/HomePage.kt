package com.example.groupproject.pages

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomePage(
    nav: NavHostController = rememberNavController(),
    app: Context
){
    Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)){
        Row(horizontalArrangement = Arrangement.Center,modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(64.dp))
        }
        //TODO(delete all page buttons)
        Row(horizontalArrangement = Arrangement.Center,modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .fillMaxWidth()){
            Text("This is where the login button was")
            /*
            PageButton(labelLang = R.string.button_page_login,LoginActivity::class.java, Modifier.weight(1.0f))
            PageButton(labelLang = R.string.button_page_schedule,ScheduleActivity::class.java,
                Modifier.weight(1.0f))
             */
        }

        Row(horizontalArrangement = Arrangement.Center,modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .fillMaxWidth()){
                Text("This is where the todo button was")
            /*
            PageButton(labelLang = R.string.button_page_todo, page = TodoActivity::class.java,
                Modifier.weight(1.0f))
            PageButton(labelLang = R.string.button_page_another, page = EventsActivity::class.java,
                Modifier.weight(1.0f))

             */
        }
        Row(horizontalArrangement = Arrangement.End,modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .fillMaxWidth()){
            Button(onClick = {/*
                val settingsActivity = Intent(this@HomepageActivity,SettingsActivity::class.java)
                startActivity(settingsActivity)
                */
            }) {
                Text(text = "Settings")
            }
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
                Text("MyTU")
            }
        }
    }
}