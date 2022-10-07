package com.invoice.contratista.ui.fragment.notes

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.data.local.entity.event.NoteEntity
import com.invoice.contratista.data.shared_preferences.UtilsManager
import com.invoice.contratista.domain.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
    private val utilsManager: UtilsManager
) : ViewModel() {

    val notes = MediatorLiveData<List<NoteEntity>>().apply {
        addSource(noteRepository.getNotes()) {
            if (it.isNotEmpty()) value = it
        }
    }

    fun createNote() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                noteRepository.createNote()
            }
        }
    }

    fun setNote(noteEntity: NoteEntity) {
        utilsManager.setIdNote(noteEntity.id)
    }
}