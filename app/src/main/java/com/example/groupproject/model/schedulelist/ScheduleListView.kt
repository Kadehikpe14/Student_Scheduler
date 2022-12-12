package com.example.groupproject.model.schedulelist

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.groupproject.GenerateScheduleConfirmDialogueBox.GSConfirmDialogue
import com.example.groupproject.GenerateScheduleConfirmDialogueBox.GSConfirmViewModel
import com.example.groupproject.model.user.UserViewModel
import kotlinx.coroutines.CoroutineScope


//TODO change schedule == null to tuid
@Composable
fun ScheduleListView(
    schedule: List<scheduleItem>?,
    getSchedule: () -> Unit,
    gsvm: GSConfirmViewModel,
    uservm: UserViewModel,

    ){
    //if there are no items in schedule,
    // display a button that prompts for TUID
    // and generate a schedule
    GSConfirmDialogue(title = "Import", text = "Enter a TUID and click 'Import'", vm = gsvm, uservm = uservm)
    if(schedule == null){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ){
            Text("There's nothing here")
            Button(onClick = {gsvm.showConfirmGenerate(onConfirm = {getSchedule()})}){
                Text("Import Schedule")
            }
        }
    }

    else{
        LazyColumn {
            itemsIndexed(schedule) {idx, scheduleItem ->
                ScheduleRow(scheduleItem)
            }


        }
        //this row is simply to so that the bottom bar doesn't content
        Row(modifier = Modifier.padding(vertical = 28.dp)){}
    }

}

@Composable
fun ScheduleRow(
    item: scheduleItem
){
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    )
    {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(12.dp)
        ) {
            Text(item.className)
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            Text(item.location)
        }
        Row(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(item.day + ":   ")
            Text(item.time)
        }
    }
    }
}
