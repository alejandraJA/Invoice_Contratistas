package com.invoice.contratista.data.source.local.entity.event

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * # Agenda
 * @param id Identificador del daily
 * @param idEvent Identificador del evento al que pertenece el daily
 * @param date Fecha para la que fue agendado
 * @param note Nota acerca del daily
 * @param idAddress Lugar en el que pasara el evento
 */
@Entity(tableName = "schedule")
class ScheduleEntity(
    @PrimaryKey(autoGenerate = false) val id: String,
    @ColumnInfo(name = "id_event") val idEvent: String,
    val date: String,
    val state: String,
    val note: String,
    @ColumnInfo(name = "id_address") val idAddress: String,
    val name: String
)