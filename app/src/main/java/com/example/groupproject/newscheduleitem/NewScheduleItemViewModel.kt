package com.example.groupproject.newscheduleitem

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.groupproject.model.scheduleItem

class NewScheduleItemViewModel: ViewModel() {
    private val _classname: MutableState<String> = mutableStateOf("")
    val classname: State<String> = _classname
    private val _isOnline: MutableState<Boolean> = mutableStateOf(false)
    val isOnline: State<Boolean> = _isOnline
    private val _location: MutableState<String> = mutableStateOf("")
    val location: State<String> = _location
    private val _days: MutableState<List<scheduleItem.validDays>> = mutableStateOf(listOf(scheduleItem.validDays.Empty))
    val days: State<List<scheduleItem.validDays>> = _days
    private val _timeBlock: MutableState<String> = mutableStateOf("")
    val timeBlock: State<String> = _timeBlock

    fun setClassname(classname: String){
        _classname.value = classname
    }
    fun setLocation(loc: String){
        _location.value = loc
    }
    fun setDays(days: List<scheduleItem.validDays>){
        _days.value = days
    }
    fun setTimeblock(tb: String){
        _timeBlock.value = tb
    }

    fun getScheduleItem(): scheduleItem{
        if(classname.value.isEmpty()) throw Exception("No classname given")
        if(location.value.isEmpty()) throw Exception("No location given")
        return scheduleItem(classname.value, isOnline.value, days.value, timeBlock.value, location.value)
    }
    //TODO() add all the shit
}