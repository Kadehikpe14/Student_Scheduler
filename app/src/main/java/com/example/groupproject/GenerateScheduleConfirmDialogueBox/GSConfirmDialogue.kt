package com.example.groupproject.GenerateScheduleConfirmDialogueBox

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

@Composable
fun GSConfirmDialogue(
    title: String,
    text: String,
    vm: GSConfirmViewModel
){
    val show by vm.showConfirmDialog
    if(show){
        AlertDialog(onDismissRequest = { /*TODO*/ },
            title = { Text(title)},
            text = {Text(text)},
            confirmButton = {
                OutlinedTextField(value = vm.TUID.value , onValueChange = vm::setTUID, placeholder = {Text("Towson UID")})
                Button(onClick = vm::onConfirmGenerate){
                    Text("Import")
                }
            })
        
    }
}