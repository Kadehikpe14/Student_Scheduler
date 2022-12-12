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
    fun getUser(): User{
        var user = User(this._username.value, this._password.value, this._tuid.value)
        return user
    }
    //sets user as null, since _isloggedin is false
    //it will not show nav buttons on top/bottom bar
    fun logoutUser(){
        _username.value = ""
        _tuid.value = ""
        _isLoggedIn.value = false
    }
    //sets user, for use with db.getUser
    fun setUser(user: User){
        _username.value = user.username
        _tuid.value = user.TUID
        _isLoggedIn.value = true
    }

}