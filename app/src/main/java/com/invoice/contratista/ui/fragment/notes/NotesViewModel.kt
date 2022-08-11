package com.invoice.contratista.ui.fragment.notes

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.data.local.entity.event.NoteEntity
import com.invoice.contratista.data.shared_preferences.UtilsManager
import com.invoice.contratista.domain.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val dataRepository: DataRepository,
    private val utilsManager: UtilsManager
) : ViewModel() {

    val notes = MediatorLiveData<List<NoteEntity>>().apply {
        addSource(dataRepository.getNotes()) {
            if (it.isNotEmpty()) value = it
        }
    }

    fun createNote() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dataRepository.createNote()
            }
        }
    }

    fun setNote(noteEntity: NoteEntity) {
        utilsManager.setIdNote(noteEntity.id)
    }
}