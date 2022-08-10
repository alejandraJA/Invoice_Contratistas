package com.invoice.contratista.ui.fragment.event.data

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.invoice.contratista.data.local.entity.DateEntity
import com.invoice.contratista.data.local.relations.Event
import com.invoice.contratista.domain.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EventDataViewModel @Inject constructor(private val dataRepository: DataRepository) : ViewModel() {
    val event = MediatorLiveData<Event>().apply {
        addSource(dataRepository.getEvent()) {
            if (it != null) value = it
        }
    }

    val dates = MediatorLiveData<List<DateEntity>>().apply {
        addSource(dataRepository.getDates()) {
            if (it != null) value = it
        }
    }
}