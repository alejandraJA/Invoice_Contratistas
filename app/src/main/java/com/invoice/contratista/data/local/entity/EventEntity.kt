package com.invoice.contratista.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * # Evento
 * @param id Identificador para el evento.
 * @param id_customer Identificador para relacionarlo con el cliente.
 * @param note Notas adicionales sobre el evento.
 * @param event_name Nombre del evento
 * @param state Estado en el que se encuentra el evento. El dato puede ser:
 * - **Creado** - Se acaba de iniciar.
 * - **Levantado** - Se realizo la primera visita o el estimamiento.
 * - **Cotizando** - Se esta realizando la cotización.
 * - **Enviado** - Cotización Enviada.
 * - **Aprobado** - Se aprobo la cotización.
 * - **Cancelado** - El cliente cancelo o se invalido.
 * - **Pendiente** - Se abono el anticipo y se debe agendar la visita.
 * - **Realizado** - Se realizo el trabajo.
 * - **Finiquitado** - Se abono el finiquito.
 */
@Entity(tableName = "event")
data class EventEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val id_customer: String,
    val state: String,
    val note: String,
    val event_name: String,
)