package com.invoice.contratista.ui.fragment.schedule

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.invoice.contratista.data.local.entity.event.ScheduleEntity
import com.invoice.contratista.data.shared_preferences.UtilsManager
import com.invoice.contratista.domain.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val dataRepository: DataRepository,
    private val utilsManager: UtilsManager
) : ViewModel() {

    fun setSchedule(idSchedule: String, action: Boolean) {
        utilsManager.setIdSchedule(idSchedule)
        utilsManager.setAction(action)
    }

    val schedule = MediatorLiveData<List<ScheduleEntity>>().apply {
        addSource(dataRepository.getSchedulesByEvent()) {
            if (it.isNotEmpty()) value = it
        }
    }

}