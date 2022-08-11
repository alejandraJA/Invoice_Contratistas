package com.invoice.contratista.ui.fragment.notes.create

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.data.local.entity.event.NoteEntity
import com.invoice.contratista.domain.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CreateEditNoteViewModel @Inject constructor(private val dataRepository: DataRepository) :
    ViewModel() {
    val note = MediatorLiveData<String>().apply {
        addSource(dataRepository.getNote()) {
            if (it != null) value = it
        }
    }

    fun updateNote(note: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dataRepository.updateNote(note)
            }
        }
    }
}