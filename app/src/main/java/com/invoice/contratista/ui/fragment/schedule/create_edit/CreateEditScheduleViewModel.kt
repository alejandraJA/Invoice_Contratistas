package com.invoice.contratista.ui.fragment.schedule.create_edit

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.data.local.entity.AddressEntity
import com.invoice.contratista.data.local.entity.event.ScheduleEntity
import com.invoice.contratista.data.shared_preferences.UtilsManager
import com.invoice.contratista.domain.ScheduleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CreateEditScheduleViewModel @Inject constructor(
    private val scheduleRepository: ScheduleRepository,
    private val utilsManager: UtilsManager
): ViewModel() {
    fun setSchedule(date: String, note: String, address: AddressEntity) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                scheduleRepository.insertSchedule(date, note, address)
            }
        }
    }

    fun getState() = utilsManager.getAction()

    fun updateStateSchedule() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                scheduleRepository.updateStateSchedule()
            }
        }
    }

    val schedule = MediatorLiveData<ScheduleEntity>().apply {
        addSource(scheduleRepository.getSchedule()) {
            if (it != null && !utilsManager.getAction()) value = it
        }
    }

    val address = MediatorLiveData<AddressEntity>().apply {
        addSource(scheduleRepository.getAddressOfSchedule()) {
            if (it != null && !utilsManager.getAction()) value = it
        }
    }
}