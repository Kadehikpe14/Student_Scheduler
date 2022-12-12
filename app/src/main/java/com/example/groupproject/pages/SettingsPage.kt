package com.example.groupproject.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.*
import com.example.groupproject.R
@Composable
fun SettingsPage(){
    Column(modifier = Modifier.fillMaxHeight()) {
        Row(horizontalArrangement = Arrangement.Center,modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp)) {
            TextField(value = "", onValueChange = {}, placeholder = {
                Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                    Text("Search") //TODO allow it to search, but there's no other setting pages
                }
            })
        }
        ButtonRow(stringResource(id = R.string.button_settings_account))
        ButtonRow(stringResource(id = R.string.button_settings_appearance))
        ButtonRow(stringResource(id = R.string.button_settings_general))
        ButtonRow(stringResource(id = R.string.button_settings_preferences))
    }
}
@Composable
fun ButtonRow(name: String){
    Row(horizontalArrangement = Arrangement.Center,modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp, vertical = 8.dp)) {
        Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = name)
        }
    }
}