package com.invoice.contratista.data.source.local.entity.event

import androidx.room.ColumnInfo
import androidx.room.Entity

/**
 * # Objeto Partida
 *
 * @param id Identificador para la partida.
 * @param number Número de la partida.
 * @param idBudget Identificador de la cotización a la que pertenece la partida.
 * @param quantity Cantidad.
 * @param discount Descuento aplicado a la partida.
 */
@Entity(tableName = "part", primaryKeys = ["id", "reserved_id"])
data class PartEntity(
    var id: String,
    val number: Int,
    @ColumnInfo(name = "budget_id") var idBudget: String,
    val quantity: Int,
    val discount: Double,
    @ColumnInfo(name = "reserved_id")val reservedId: String
)