package com.invoice.contratista.ui.fragment.schedule

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.invoice.contratista.data.repository.local.ScheduleRepository
import com.invoice.contratista.data.source.local.entity.event.ScheduleEntity
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val scheduleRepository: ScheduleRepository,
    private val utilsManager: UtilsManager
) : ViewModel() {

    fun setSchedule(idSchedule: String, action: Boolean) {
        utilsManager.setIdSchedule(idSchedule)
        utilsManager.setAction(action)
    }

    val schedule = MediatorLiveData<List<ScheduleEntity>>().apply {
        addSource(scheduleRepository.getSchedulesByEvent()) {
            if (it.isNotEmpty()) value = it
        }
    }

}