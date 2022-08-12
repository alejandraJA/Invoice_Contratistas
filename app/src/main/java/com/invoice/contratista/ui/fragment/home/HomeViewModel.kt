package com.invoice.contratista.ui.fragment.home

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.invoice.contratista.data.local.entity.EventEntity
import com.invoice.contratista.data.local.entity.event.ScheduleEntity
import com.invoice.contratista.data.shared_preferences.UtilsManager
import com.invoice.contratista.domain.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dataRepository: DataRepository,
    private val utilsManager: UtilsManager
) : ViewModel() {
    fun saveEvent(event: EventEntity) {
        utilsManager.setIdEvent(event.id)
        utilsManager.setIdCustomer(event.id_customer)
    }

    fun setSchedule(idSchedule: String, action: Boolean) {
        utilsManager.setIdSchedule(idSchedule)
        utilsManager.setAction(action)
    }

    val event = MediatorLiveData<List<EventEntity>>().apply {
        addSource(dataRepository.getEvents()) {
            if (it.isNotEmpty()) value = it
        }
    }

    val schedule = MediatorLiveData<List<ScheduleEntity>>().apply {
        addSource(dataRepository.getSchedules()) {
            if (it.isNotEmpty()) value = it
        }
    }
}