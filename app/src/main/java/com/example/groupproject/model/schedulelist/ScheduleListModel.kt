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
        val className = listOf("Databases", "Mobile App Development", "Web Development", "Requirements Analysis")
        val location = listOf("YR303", "YR402", "YR205", "YR303")
        _schedule.value = (0..3).map{i ->
            scheduleItem(className[i], location[i])
        }
    }
}