package com.invoice.contratista.ui.fragment.event.data

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.data.local.entity.DateEntity
import com.invoice.contratista.data.local.relations.Event
import com.invoice.contratista.domain.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class EventDataViewModel @Inject constructor(private val dataRepository: DataRepository) : ViewModel() {

    fun updateNote(note: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dataRepository.updateNote(note)
            }
        }
    }

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