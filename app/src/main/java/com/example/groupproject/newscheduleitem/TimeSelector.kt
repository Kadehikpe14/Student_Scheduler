package com.example.groupproject.newscheduleitem

import androidx.compose.foundation.layout.Column
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun TimeSelector(
    //vm
    isOnline: Boolean
){
    Text("Select time: ")
    DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
        
    }
}