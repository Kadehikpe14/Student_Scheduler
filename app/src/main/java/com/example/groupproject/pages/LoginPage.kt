package com.example.groupproject.pages

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.groupproject.navigation.Routes
import com.example.groupproject.R
import com.example.groupproject.data.UserDatabaseRepo
import com.example.groupproject.model.user.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun LoginPage(
    nav: NavHostController = rememberNavController(),
    uservm: UserViewModel,
    coroutineScope: CoroutineScope,
    app: Context
){
    //no time for viewmodel :(
    var username = remember { mutableStateOf("") }
    var password = remember {mutableStateOf("") }
    var errorMsg = remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),

    ){
        Text(text = stringResource(id = R.string.login),
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
        Text(errorMsg.value, color = androidx.compose.ui.graphics.Color.Red, fontSize = 16.sp)

        Button(onClick = {
            //launch scope for database ops
            coroutineScope.launch {
                //initiate database,
                //set a tempUser = value from "getUser" function
                val userrepo = UserDatabaseRepo(app)
                var tempUser = userrepo.getUser(username.value)
                //if tempUser does not exist set error msg
                if(tempUser == null){
                    errorMsg.value = "User does not exist"
                }
                //if temp user does exist, check passwords
                else{
                    if(tempUser.password != password.value){
                        errorMsg.value = "Incorrect Password"
                    }
                    //if passwords match, set user = tempUser
                    else{
                        uservm.setUser(tempUser)
                        nav.navigate(Routes.HomePage.route) {
                            popUpTo(Routes.HomePage.route)
                        }
                    }
                }
            }
        }
        )
        {
            Text(text = stringResource(id = R.string.login), fontSize = 25.sp)
        }
        //make "Don't have an account?" clickable and go to signup page
        Text(text = stringResource(id = R.string.inform_login_signup),
            modifier = Modifier.clickable {
                nav.navigate(Routes.Signup.route) {
                    popUpTo(Routes.Signup.route)
                }
            })
}}
