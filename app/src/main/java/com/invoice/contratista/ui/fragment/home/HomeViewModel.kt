package com.invoice.contratista.ui.fragment.home

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.invoice.contratista.data.repository.EventRepository
import com.invoice.contratista.data.repository.ScheduleRepository
import com.invoice.contratista.data.source.local.entity.EventEntity
import com.invoice.contratista.data.source.local.entity.event.ScheduleEntity
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val scheduleRepository: ScheduleRepository,
    private val eventRepository: EventRepository,
    private val utilsManager: UtilsManager
) : ViewModel() {
    fun saveEvent(event: EventEntity) {
        utilsManager.setIdEvent(event.id)
        utilsManager.setIdCustomer(event.idCustomer)
    }

    fun setSchedule(idSchedule: String, action: Boolean) {
        utilsManager.setIdSchedule(idSchedule)
        utilsManager.setAction(action)
    }

    val event = MediatorLiveData<List<EventEntity>>().apply {
        addSource(eventRepository.getEvents()) {
            if (it.isNotEmpty()) value = it
        }
    }

    val schedule = MediatorLiveData<List<ScheduleEntity>>().apply {
        addSource(scheduleRepository.getSchedules()) {
            if (it.isNotEmpty()) value = it
        }
    }
}