package com.example.groupproject.pages

import android.app.Application
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.AndroidViewModel
import androidx.room.util.TableInfo
import com.example.groupproject.data.UserDatabaseRepo
import com.example.groupproject.model.user.UserViewModel


@Composable
fun SignupPage(uservm: UserViewModel, app: Context){

    //val userrepo = UserDatabaseRepo(app)
    var username= remember { mutableStateOf("") }
    var password = remember {mutableStateOf("")}
    var password2 = remember {mutableStateOf("")}

    Column(verticalArrangement = Arrangement.SpaceEvenly) {
        Text("Signup Page")

    }

    }
