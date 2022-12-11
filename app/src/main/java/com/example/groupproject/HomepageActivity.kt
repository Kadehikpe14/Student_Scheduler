package com.example.groupproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groupproject.ui.theme.GroupProjectTheme

class HomepageActivity : ComponentActivity() {

    //TODO: Refactor folders

    //TODO: Navigation combines Homepage, Settings, and About

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroupProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = { TopAppBar(
                            title = {Text("Welcome to Student Scheduler", fontSize = 25.sp, color = Color.White)},
                            backgroundColor = Color(0xFF0718C4))  },
                        content = {
                    Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)){
                        Row(horizontalArrangement = Arrangement.Center,modifier = Modifier.fillMaxWidth()) {
                            Spacer(modifier = Modifier
                                .fillMaxWidth()
                                .height(64.dp))
                        }
                        Row(horizontalArrangement = Arrangement.Center,modifier = Modifier
                            .padding(vertical = 8.dp, horizontal = 24.dp)
                            .fillMaxWidth()){
                            PageButton(labelLang = R.string.button_page_login,LoginActivity::class.java,Modifier.weight(1.0f))
                            PageButton(labelLang = R.string.button_page_schedule,ScheduleActivity::class.java,Modifier.weight(1.0f))
                        }
                        Row(horizontalArrangement = Arrangement.Center,modifier = Modifier
                            .padding(vertical = 8.dp, horizontal = 24.dp)
                            .fillMaxWidth()){
                            PageButton(labelLang = R.string.button_page_todo, page = TodoActivity::class.java,Modifier.weight(1.0f))
                            PageButton(labelLang = R.string.button_page_another, page = EventsActivity::class.java,Modifier.weight(1.0f))
                        }
                        Row(horizontalArrangement = Arrangement.End,modifier = Modifier
                            .padding(vertical = 8.dp, horizontal = 24.dp)
                            .fillMaxWidth()){
                            Button(onClick = {
                                val settingsActivity = Intent(this@HomepageActivity,SettingsActivity::class.java)
                                startActivity(settingsActivity) },
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE47001))) {
                                Text(text = "Settings",  color = Color.White, fontSize = 20.sp)
                            }
                        }
                    }
                        })
                }
            }
        }
    }

    @Composable
    fun PageButton(labelLang: Int,page: Class<out ComponentActivity>,modifier: Modifier = Modifier){
        Button(onClick = {
            val activity = Intent(this@HomepageActivity,page)
            startActivity(activity)
        }, modifier = modifier
            .height(128.dp)
            .padding(horizontal = 8.dp)) {
            Text(text = stringResource(id = labelLang), fontSize = 25.sp)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    GroupProjectTheme {}
}