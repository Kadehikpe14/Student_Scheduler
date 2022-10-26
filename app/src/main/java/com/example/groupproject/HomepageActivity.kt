package com.example.groupproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groupproject.ui.theme.GroupProjectTheme

class HomepageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroupProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)){
                        Row(horizontalArrangement = Arrangement.Center,modifier = Modifier.fillMaxWidth()) {

                        }
                        Row(horizontalArrangement = Arrangement.Center,modifier = Modifier
                            .padding(vertical = 32.dp, horizontal = 24.dp)
                            .fillMaxWidth()){
                            Button(onClick = { /*TODO*/ }, modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding(horizontal = 8.dp)) {
                                Text(text = stringResource(id = R.string.button_page_login), fontSize = 24.sp)
                            }
                            Button(onClick = { /*TODO*/ }, modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp)) {
                                Text(text = stringResource(id = R.string.button_page_schedule), fontSize = 24.sp)
                            }
                        }
                        Row(horizontalArrangement = Arrangement.Center,modifier = Modifier
                            .padding(vertical = 32.dp, horizontal = 24.dp)
                            .fillMaxWidth()){
                            Button(onClick = { /*TODO*/ }, modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding(horizontal = 8.dp)) {
                                Text(text = stringResource(id = R.string.button_page_todo), fontSize = 24.sp)
                            }
                            Button(onClick = { /*TODO*/ }, modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp)) {
                                Text(text = stringResource(id = R.string.button_page_another), fontSize = 24.sp)
                            }
                        }
                        Row(horizontalArrangement = Arrangement.Center,modifier = Modifier
                            .padding(vertical = 32.dp, horizontal = 24.dp)
                            .fillMaxWidth()){

                        }
                        Greeting2("Android")
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    GroupProjectTheme {
        Greeting2("Android")
    }
}