package com.invoice.contratista.ui.fragment.schedule.create_edit

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.data.local.entity.AddressEntity
import com.invoice.contratista.data.local.entity.event.ScheduleEntity
import com.invoice.contratista.data.shared_preferences.UtilsManager
import com.invoice.contratista.domain.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CreateEditScheduleViewModel @Inject constructor(
    private val dataRepository: DataRepository,
    private val utilsManager: UtilsManager
): ViewModel() {
    fun setSchedule(date: String, note: String, address: AddressEntity) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dataRepository.insertSchedule(date, note, address)
            }
        }
    }

    fun getState() = utilsManager.getAction()

    fun updateStateSchedule() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dataRepository.updateStateSchedule()
            }
        }
    }

    val schedule = MediatorLiveData<ScheduleEntity>().apply {
        addSource(dataRepository.getSchedule()) {
            if (it != null && !utilsManager.getAction()) value = it
        }
    }

    val address = MediatorLiveData<AddressEntity>().apply {
        addSource(dataRepository.getAddressOfSchedule()) {
            if (it != null && !utilsManager.getAction()) value = it
        }
    }
}