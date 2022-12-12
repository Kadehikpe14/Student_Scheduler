package com.example.groupproject.model.schedulelist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ScheduleListModel : ViewModel()  {
    var origSchedule: List<scheduleItem>? = null
    val _schedule = mutableStateOf(origSchedule)
    val _TUID = mutableStateOf("")
    val TUID: State<String> = _TUID
    val schedule: State<List<scheduleItem>?> = _schedule
    init{

    }

    fun generateSchedule(){
        val className = listOf("Databases", "Mobile App Development", "Web Development", "Requirements Analysis", "Statistics")
        val location = listOf("YR303", "YR402", "YR205", "YR303", "YR105")
        val days = listOf("Wed", "Mon", "Tues", "MonWed", "TuesThurs")
        val times = listOf("7:00pm", "7:00pm", "7:00pm", "12:30pm", "1:45pm")
        _schedule.value = (0..4).map{i ->
            scheduleItem(className[i], days[i], times[i], location[i])
        }
    }
}