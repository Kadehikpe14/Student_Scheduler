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
    private val _daysholder: MutableState<List<scheduleItem.validDays>> = mutableStateOf(listOf(scheduleItem.validDays.Empty))
    val daysholder: State<List<scheduleItem.validDays>> = _daysholder
    private val _days: MutableState<List<scheduleItem.validDays>> = mutableStateOf(listOf(scheduleItem.validDays.Empty))
    val days: State<List<scheduleItem.validDays>> = _days
    private val _timeBlock: MutableState<String> = mutableStateOf("")
    val timeBlock: State<String> = _timeBlock
    private val _formattedDays:MutableState<String> = mutableStateOf("")
    val formattedDays: State<String> = _formattedDays

    fun setClassname(classname: String){
        _classname.value = classname
    }
    fun setLocation(loc: String){
        _location.value = loc
    }
    fun setDays(days: List<scheduleItem.validDays>){
        _days.value = _daysholder.value
    }
    fun setTimeblock(tb: String){
        _timeBlock.value = tb
    }
    fun toggleDays(day: scheduleItem.validDays){
        if(!_daysholder.value.contains(day)){
            _daysholder.value = _daysholder.value + listOf(day)
        }
        else{
            val idx = _daysholder.value.indexOf(day);
            _daysholder.value = _daysholder.value.subList(0, idx) + _daysholder.value.subList(idx+1, _daysholder.value.size)
        }
    }
    fun toggleOnline(){
        _isOnline.value = !_isOnline.value
    }
    fun formatDays(){
        var s:String = ""
        if(_days.value.contains(scheduleItem.validDays.Monday)){
            s += "Mon "
        }
        if(_days.value.contains(scheduleItem.validDays.Tuesday)){
            s += "Tues "
        }
        if(_days.value.contains(scheduleItem.validDays.Wednesday)){
            s += "Wed "
        }
        if(_days.value.contains(scheduleItem.validDays.Thursday)){
            s += "Thur "
        }
        if(_days.value.contains(scheduleItem.validDays.Friday)){
            s += "Fri "
        }

    }
    fun getScheduleItem(): scheduleItem?{
        if(classname.value.isEmpty()) throw Exception("No classname given")
        if(location.value.isEmpty()) throw Exception("No location given")
        if(!isOnline.value && daysholder.value.size == 1) throw Exception("No days selected")
        return null;
        //return scheduleItem(classname.value, isOnline.value, days.value, timeBlock.value, location.value)
    }
    //TODO() add all the shit
}