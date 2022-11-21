package com.example.groupproject

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.groupproject.model.scheduleItem

@Composable
fun ScheduleRow(
    item: scheduleItem
){
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 5.dp, bottom = 5.dp).fillMaxWidth()
    )
    {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Text(item.className)
            Spacer(modifier = Modifier
                .weight(1f)
            )
            Text(item.location)
        }
    }
}
