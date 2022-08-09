package com.invoice.contratista.data.local.entity.event

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * # Agenda
 * @param id Identificador del daily
 * @param id_event Identificador del evento al que pertenece el daily
 * @param date Fecha para la que fue agendado
 * @param note Nota acerca del daily
 * @param location Lugar en el que pasara el evento
 */
@Entity(tableName = "schedule")
class ScheduleEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val id_event: Long,
    val date: String,
    val state: String,
    val note: String,
    val location: String,
)