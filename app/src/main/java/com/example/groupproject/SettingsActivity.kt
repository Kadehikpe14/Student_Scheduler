package com.example.groupproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groupproject.ui.theme.GroupProjectTheme

class SettingsActivity : ComponentActivity() {

    //TODO: naviagtion to the about page

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
                                title = {Text("Settings", color = Color.White)},
                                backgroundColor = Color(0xFF0718C4)
                            ) },
                            content = {
                                Column(modifier = Modifier.fillMaxHeight()) {
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 12.dp, vertical = 8.dp)
                                    ) {
                                        TextField(value = "", onValueChange = {}, placeholder = {
                                            Row(
                                                horizontalArrangement = Arrangement.Center,
                                                modifier = Modifier.fillMaxWidth()
                                            ) {
                                                Text(
                                                    text = stringResource(id = R.string.button_settings_searchbar),
                                                    fontSize = 16.sp
                                                )
                                            }
                                        })
                                    }
                                    ButtonRow(stringResource(id = R.string.button_settings_account))
                                    ButtonRow(stringResource(id = R.string.button_settings_appearance))
                                    ButtonRow(stringResource(id = R.string.button_settings_general))
                                    ButtonRow(stringResource(id = R.string.button_settings_preferences))
                                }

                            })
                }
            }
        }
    }
}

@Composable
fun ButtonRow(name: String){
    Row(horizontalArrangement = Arrangement.Center,modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp, vertical = 8.dp)) {
        Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = name)
        }
    }
}

@Composable
fun Greeting4(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    GroupProjectTheme {
        Greeting4("Android")
    }
}