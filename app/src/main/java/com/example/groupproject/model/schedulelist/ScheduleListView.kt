package com.example.groupproject.model.schedulelist

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

@Composable
fun ScheduleListView(
    schedule: List<scheduleItem>?,
    getSchedule: () -> Unit,
    gsvm: GSConfirmViewModel,

    ){
    GSConfirmDialogue(title = "Import", text = "Enter a TUID and click 'Import'", vm = gsvm)
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
    }

}

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
