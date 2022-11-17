package com.example.groupproject.newscheduleitem

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.groupproject.model.scheduleItem
//import androidx.lifecycle.viewmodel.compose.viewModel

@ExperimentalComposeUiApi
@Composable
fun NewScheduleItemView(
    //vm: NewScheduleItemViewModel = viewModel(),
    //addScheduleItem: (scheduleItem) -> Unit
) {
    var value1: String = ""

    Column()

    {
        Row {
            Text("Course: ")
            OutlinedTextField(value = value1, onValueChange = {}) //, singleLine = true, ){
        }

        Row() {
            Text("Online: ")
            Checkbox(checked = false, onCheckedChange = {})
        }
        Row() {
            Text("Enter location: ")
            OutlinedTextField(value = value1, onValueChange = {})
        }
        Row {
            DaySelector(false)
        }
        Row() {
            Text("Select Time: ")

        }
        Button(onClick = {}){
            Text("Add")
        }

    }
}
