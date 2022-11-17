package com.example.groupproject.schedulelist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.groupproject.model.scheduleItem

class ScheduleListModel : ViewModel()  {
    var origSchedule = null
    val _schedule = mutableStateOf(origSchedule)
    val schedule: State<List<scheduleItem>?> = _schedule

    init{ }

    fun addClass(item: scheduleItem){

    }
}