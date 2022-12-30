package com.invoice.contratista.ui.fragment.event.data

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.data.repository.local.DatesRepository
import com.invoice.contratista.data.repository.local.EventRepository
import com.invoice.contratista.data.source.local.entity.DateEntity
import com.invoice.contratista.data.source.local.relations.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class EventDataViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    private val datesRepository: DatesRepository
) : ViewModel() {

    fun updateNote(note: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                eventRepository.updateNoteEvent(note)
            }
        }
    }

    val event = MediatorLiveData<Event>().apply {
        addSource(eventRepository.getEvent()) {
            if (it != null) value = it
        }
    }

    val dates = MediatorLiveData<List<DateEntity>>().apply {
        addSource(datesRepository.getDates()) {
            if (it != null) value = it
        }
    }
}