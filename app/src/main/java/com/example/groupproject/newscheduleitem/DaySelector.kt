package com.example.groupproject.newscheduleitem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun DaySelector(
    //vm = ...
    isOnline: Boolean
){
    if(!isOnline){
        Column{
            Row{
                Text("Monday")
                Checkbox(checked = false, onCheckedChange = {})
        }
            Row{
                Text("Tuesday")
                Checkbox(checked = false, onCheckedChange = {})
        }
            Row{
                Text("Wednesday")
                Checkbox(checked = false, onCheckedChange = {})
        }
    }
        Column{
            Row{
                Text("Thursday")
                Checkbox(checked = false, onCheckedChange = {})
            }
            Row{
                Text("Friday")
                Checkbox(checked = false, onCheckedChange = {})
            }
        }
    }
}