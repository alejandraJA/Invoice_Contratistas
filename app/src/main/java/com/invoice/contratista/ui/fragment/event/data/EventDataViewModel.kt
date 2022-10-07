package com.invoice.contratista.ui.fragment.event.data

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.data.local.entity.DateEntity
import com.invoice.contratista.data.local.relations.Event
import com.invoice.contratista.domain.DatesRepository
import com.invoice.contratista.domain.EventRepository
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