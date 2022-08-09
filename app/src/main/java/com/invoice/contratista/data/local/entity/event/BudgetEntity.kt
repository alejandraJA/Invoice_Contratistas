package com.invoice.contratista.data.local.entity.event

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * # Clase Cotización
 *
 * @param id Identificador de la cotización.
 * @param number Campo autoincremental para las cotizaciones para llevar un control interno.
 * @param id_customer Identificador para hacer refrencia al cliente al que va dirigida la cotización.
 * @param id_event Identificador del evento al que pertece la cotización.
 * @param date Fecha en la que se envía la cotización
 * @param dateEnd Fecha en la que la cotización invalida.
 * @param conditions Condiciones de pago para la cotización.
 * @param status Estatus en el que se encunetra la cotización.
 */
@Entity(tableName = "budget", primaryKeys = ["id", "id_customer"])
data class BudgetEntity(
    val id: Long,
    val number: Int,
    val id_customer: String,
    val id_event: Long,
    val date: String,
    val dateEnd: String,
    val conditions: String,
    val status: String,
)