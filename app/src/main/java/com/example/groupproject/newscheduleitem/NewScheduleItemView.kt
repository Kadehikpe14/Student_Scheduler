package com.example.groupproject.newscheduleitem

import android.graphics.Paint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groupproject.model.scheduleItem
//import androidx.lifecycle.viewmodel.compose.viewModel

@ExperimentalComposeUiApi
@Composable
fun NewScheduleItemView(
    //vm: NewScheduleItemViewModel = viewModel(),
    //toggleOnline: ()-> Unit
    //addScheduleItem: (scheduleItem) -> Unit
    //toggleDay: (scheduleItem.validDays) -> Unit
) {
    var value1: String = ""

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    )
    {
        Text("New Course", modifier = Modifier.padding(16.dp), fontSize = 28.sp)
        Row(

        ) {
            OutlinedTextField(value = value1, onValueChange = {}, singleLine = true, placeholder = {Text("Course Name")}, label = {Text("Course")}) //, singleLine = true, ){
        }
        Row(
        ) {
            OutlinedTextField(value = value1, onValueChange = {}, singleLine = true, placeholder = {Text("Location")}, label = {Text("Location")})
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Online: ")
            Spacer(modifier = Modifier.weight(1f))
            Checkbox(checked = false, onCheckedChange = {})
        }
        Row {
            DaySelector(false)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ) {
            Text("Online: ")
            Spacer(modifier = Modifier.weight(1f))
            Checkbox(checked = false, onCheckedChange = {})
        }
        Row() {
            Text("Start Time: ")
        }
        Row() {
            Text("End Time: ")
        }
        Button(onClick = {}){
            Text("Add")
        }
    }
}
