package com.example.groupproject.GenerateScheduleConfirmDialogueBox

import android.content.Context
import android.graphics.Color.RED
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.groupproject.data.UserDatabaseRepo
import com.example.groupproject.model.user.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun GSConfirmDialogue(
    title: String,
    text: String,
    vm: GSConfirmViewModel,
    uservm: UserViewModel,
){
    val show by vm.showConfirmDialog
    if(show){

        AlertDialog(onDismissRequest = {},
            title = { Text(title)},
            text = {Text(text)},
            confirmButton = {
                var errMsg = remember { mutableStateOf("") }
                OutlinedTextField(value = vm.TUID.value,
                    onValueChange = vm::setTUID,
                    placeholder = {Text("Towson UID")})
                Text(errMsg.value, color = androidx.compose.ui.graphics.Color.Red)
                Button(modifier = Modifier.fillMaxWidth(),
                       onClick =  vm::onConfirmGenerate
                ){
                    Text("Import")
                }
                }
            )
        
    }
}