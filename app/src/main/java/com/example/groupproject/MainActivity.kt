package com.example.groupproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.groupproject.GenerateScheduleConfirmDialogueBox.GSConfirmViewModel
import com.example.groupproject.schedulelist.ScheduleListModel
import com.example.groupproject.schedulelist.ScheduleListView
import com.example.groupproject.ui.theme.GroupProjectTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroupProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ){
                    val vm:ScheduleListModel by viewModels()
                    val schedule by vm.schedule
                    val gsvm: GSConfirmViewModel by viewModels()
                    ScheduleListView(schedule,
                        getSchedule = vm::generateSchedule,
                        gsvm
                    )

                    //NewScheduleItemView() //delete this function after initial commit
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GroupProjectTheme {
        Greeting("Android")
    }
}