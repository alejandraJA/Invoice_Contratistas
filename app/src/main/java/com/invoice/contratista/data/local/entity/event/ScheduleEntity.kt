package com.invoice.contratista.data.local.entity.event

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * # Agenda
 * @param id Identificador del daily
 * @param id_event Identificador del evento al que pertenece el daily
 * @param date Fecha para la que fue agendado
 * @param note Nota acerca del daily
 * @param id_address Lugar en el que pasara el evento
 */
@Entity(tableName = "schedule")
class ScheduleEntity(
    @PrimaryKey(autoGenerate = false) val id: String,
    val id_event: String,
    val date: String,
    val state: String,
    val note: String,
    val id_address: String,
    val name: String
)