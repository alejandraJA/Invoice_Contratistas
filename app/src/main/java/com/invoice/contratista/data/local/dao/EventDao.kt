package com.invoice.contratista.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.invoice.contratista.data.local.entity.EventEntity
import com.invoice.contratista.data.local.relations.Event

@Dao
interface EventDao {

    /**
     * Metodo para insertar un evento
     * @param event Objeto de tipo [EventEntity]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setEvent(event: EventEntity)

    /**
     * Metodo para obtener todos los eventos activos
     * @return Lista de objetos de tipo [EventEntity]
     */
    @Query("SELECT * FROM event WHERE state != 'Realizado'")
    fun getEvents(): LiveData<List<EventEntity>>

    @Transaction
    @Query("SELECT * FROM event WHERE id == :idEvent")
    fun getEvent(idEvent: String): LiveData<Event>

    @Query("UPDATE event SET note = :note WHERE id == :idEvent")
    fun updateNoteEvent(idEvent: String, note: String)

}