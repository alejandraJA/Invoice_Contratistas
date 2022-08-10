package com.invoice.contratista.ui.fragment.event_data

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
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
}