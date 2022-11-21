package com.example.groupproject.schedulelist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.groupproject.GenerateScheduleConfirmDialogueBox.GSConfirmDialogue
import com.example.groupproject.GenerateScheduleConfirmDialogueBox.GSConfirmViewModel
import com.example.groupproject.ScheduleRow
import com.example.groupproject.model.scheduleItem

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
            modifier = Modifier.padding(12.dp)
        ){
            Text("There's nothing here")
            Button(onClick = {gsvm.showConfirmGenerate(onConfirm = {getSchedule()})}){
                Text("Import Schedule")
            }
            if(schedule==null){
                Text("True")
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