package com.invoice.contratista.data.repository

import com.invoice.contratista.data.source.local.dao.NoteDao
import com.invoice.contratista.data.source.local.entity.event.NoteEntity
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
import java.util.*
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val dao: NoteDao,
    private val utilsManager: UtilsManager
) {
    fun createNote() {
        val idNote = UUID.randomUUID().toString()
        dao.createNote(NoteEntity(idNote, utilsManager.getIdEvent(), ""))
        utilsManager.setIdNote(idNote)
    }
    fun updateNote(note: String) = dao.updateNote(utilsManager.getIdNote(), note)
    fun getNotes() = dao.getNotes(utilsManager.getIdEvent())
    fun getNote() = dao.getNote(utilsManager.getIdNote())
}