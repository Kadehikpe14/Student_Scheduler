package com.example.groupproject.model.user

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {

    var _username = mutableStateOf("")
    var username: State<String> = _username

    var _password = mutableStateOf("")
    var password: State<String> = _password

    var _tuid = mutableStateOf("")
    var tuid: State<String> = _tuid

    var _isLoggedIn = mutableStateOf(false)
    var isLoggedIn: State<Boolean> = _isLoggedIn

    init {

    }
    fun loginUser(username: String, password: String) {

    }
    fun setUser(user: User){
        _username.value = user.username
        _tuid.value = user.TUID
        _isLoggedIn.value = true
    }
}