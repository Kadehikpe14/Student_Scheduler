package com.example.groupproject.newscheduleitem

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DaySelector(
    //vm = ...
    isOnline: Boolean
){
    if(!isOnline){
        Column{
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(5.dp)
            ){
                Text("Monday")
                Spacer(modifier = Modifier.weight(1f))
                Checkbox(checked = false, onCheckedChange = {}/*toggleDay(validDay.MONDAY) */)
        }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(5.dp)
            ){
                Text("Tuesday")
                Spacer(modifier = Modifier.weight(1f))
                Checkbox(checked = false, onCheckedChange = {}/*toggleDay(validDay.TUESDAY) */)
        }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(5.dp)
            ){
                Text("Wednesday")
                Spacer(modifier = Modifier.weight(1f))
                Checkbox(checked = false, onCheckedChange = {}/*toggleDay(validDay.WEDNESDAY) */)
        }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(5.dp)
            ){
                Text("Thursday")
                Spacer(modifier = Modifier.weight(1f))
                Checkbox(checked = false, onCheckedChange = {}/*toggleDay(validDay.THURSDAY) */)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(5.dp)
            ){
                Text("Friday")
                Spacer(modifier = Modifier.weight(1f))
                Checkbox(checked = false, onCheckedChange = {}/*toggleDay(validDay.FRIDAY) */)
            }
        }
    }
}