package com.invoice.contratista.ui.fragment.notes.create

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.domain.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CreateEditNoteViewModel @Inject constructor(private val noteRepository: NoteRepository) :
    ViewModel() {
    val note = MediatorLiveData<String>().apply {
        addSource(noteRepository.getNote()) {
            if (it != null) value = it
        }
    }

    fun updateNote(note: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                noteRepository.updateNote(note)
            }
        }
    }
}