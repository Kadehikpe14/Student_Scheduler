package com.example.groupproject.GenerateScheduleConfirmDialogueBox

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class GSConfirmViewModel: ViewModel() {
    private val _showConfirmDialog: MutableState<Boolean> = mutableStateOf(false)
    private var _onConfirm: (() -> Unit)? = null
    val showConfirmDialog: State<Boolean> = _showConfirmDialog
    //val _isWaiting from lab
    private var _TUID = mutableStateOf("")
    val TUID: State<String> = _TUID

    fun showConfirmGenerate(onConfirm: () -> Unit){
        _showConfirmDialog.value = true
        _onConfirm = onConfirm
    }

    fun setTUID(UID: String){
        _TUID.value = UID
    }

    fun onConfirmGenerate() {
        if(_onConfirm != null){
            _showConfirmDialog.value = false
            _onConfirm?.invoke()
        }
    }

}