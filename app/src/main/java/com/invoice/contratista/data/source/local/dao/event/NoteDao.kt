package com.invoice.contratista.data.source.local.dao.event

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.invoice.contratista.data.source.local.entity.event.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createNote(noteEntity: NoteEntity)

    @Query("UPDATE note SET note = :note WHERE id == :idNote")
    fun updateNote(idNote: String, note: String)

    @Query("SELECT * FROM note WHERE id_event == :idEvent")
    fun getNotes(idEvent: String): LiveData<List<NoteEntity>>

    @Query("SELECT note FROM note WHERE id == :idNote")
    fun getNote(idNote: String): LiveData<String>

}