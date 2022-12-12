package com.example.groupproject.pages

import android.app.Application
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.lifecycle.viewModelScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.groupproject.data.UserDatabaseRepo
import com.example.groupproject.model.user.User
import com.example.groupproject.model.user.UserViewModel
import com.example.groupproject.navigation.Routes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineScope.*
import kotlinx.coroutines.launch
import com.example.groupproject.R


@Composable
fun SignupPage(
    nav: NavHostController,
    uservm: UserViewModel,
    app: Context,
    coroutineScope: CoroutineScope){

    //No time for a view model :(
    var username= remember { mutableStateOf("") }
    var password = remember {mutableStateOf("")}
    var password2 = remember {mutableStateOf("")}
    var errorMsg = remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()) {

        Text(text = stringResource(id = R.string.signup),
            fontSize = 36.sp,
            modifier = Modifier.padding(36.dp))
        Text(text = stringResource(id = R.string.inform_prompt_username), fontSize = 28.sp)
        OutlinedTextField(value = username.value,
            onValueChange = {newvalue: String ->
                username.value = newvalue
        })
        Text(text = stringResource(id = R.string.inform_prompt_password), fontSize = 28.sp)
        OutlinedTextField(value = password.value,
            onValueChange = {newvalue: String ->
                password.value = newvalue
            })
        Text("Reenter Password", fontSize = 28.sp)
        OutlinedTextField(value = password2.value,
            onValueChange = {newvalue: String ->
                password2.value = newvalue
            })
        Text(errorMsg.value, color = Red, fontSize = 16.sp)
        //Check if user in database/add user to database
        Button(onClick = {
                    //coroutinescope passed from main activity
                    //because I couldn't think of a better way to do it
                    coroutineScope.launch{
                        val userrepo = UserDatabaseRepo(app)
                        var user2: User = userrepo.getUser(username.value)
                        //If username not found, display error message
                        if(user2!= null){
                            errorMsg.value = "User already exists"

            }       //if user doesn't exist, make sure passwords are same
                    //if passwords same, add user to repo and navigate to home
                        else{
                            if(password.value != password2.value){
                                errorMsg.value = "Passwords don't match"
                }
                            else {
                                var newUser = User(username.value, password.value, "")
                                userrepo.addUser(newUser)
                                uservm.setUser(newUser)
                                nav.navigate(Routes.HomePage.route) {
                                    popUpTo(Routes.HomePage.route)
                            }

                }
            }}
        }){
            Text(text = stringResource(id = R.string.signup))
        }



    }

}
