package com.example.groupproject.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.groupproject.GenerateScheduleConfirmDialogueBox.GSConfirmViewModel
import com.example.groupproject.model.schedulelist.ScheduleListModel
import com.example.groupproject.model.schedulelist.ScheduleListView
import com.example.groupproject.model.user.UserViewModel

@Composable
fun SchedulePage(
    vm: ScheduleListModel = viewModel(),
    gsvm: GSConfirmViewModel = viewModel(),
    uservm: UserViewModel,
){
    val schedule by vm.schedule
    ScheduleListView(schedule,
        getSchedule = vm::generateSchedule,
        gsvm,
        uservm,
    )
}