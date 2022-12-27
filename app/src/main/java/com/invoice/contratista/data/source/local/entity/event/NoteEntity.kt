package com.invoice.contratista.data.source.local.entity.event

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * # Notas
 * @param id Identificador de la nota.
 * @param idEvent Identificador del evento al que pertenece la nota
 * @param note Nota
 */
@Entity(tableName = "note")
data class NoteEntity(
    @PrimaryKey(autoGenerate = false) val id: String,
    @ColumnInfo(name = "id_event") val idEvent: String,
    val note: String,
)