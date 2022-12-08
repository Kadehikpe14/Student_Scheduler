package com.example.groupproject.GenerateScheduleConfirmDialogueBox

import android.icu.number.NumberFormatter
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class GSConfirmViewModel: ViewModel() {
    private val _showConfirmDialog: MutableState<Boolean> = mutableStateOf(false)
    //TODO() Make this generate with suspend and loader

    private var _onConfirm: (() -> Unit)? = null
    val showConfirmDialog: State<Boolean> = _showConfirmDialog
    //val _isWaiting from lab
    private var _TUID = mutableStateOf("")
    val TUID: State<String> = _TUID

    fun showConfirmGenerate(onConfirm: () -> Unit){
        _showConfirmDialog.value = true
        _onConfirm = onConfirm
        //if(_onConfirm == onConfirm){
          //  println("True")
        //}
    }

    fun setTUID(UID: String){
        _TUID.value = UID
    }

    fun onConfirmGenerate() {
        //TODO() why this?
        if(_onConfirm != null){
            _showConfirmDialog.value = false
            _onConfirm?.invoke()
        }
    }

}