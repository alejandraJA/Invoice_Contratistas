package com.invoice.contratista.data.source.local.entity.event

import androidx.room.Entity

/**
 * # Objeto Partida
 *
 * @param id Identificador para la partida.
 * @param number Número de la partida.
 * @param idBudget Identificador de la cotización a la que pertenece la partida.
 * @param idProduct Identificador del producto al que hace referencia.
 * @param quantity Cantidad.
 * @param discount Descuento aplicado a la partida.
 */
@Entity(tableName = "part", primaryKeys = ["id", "idProduct"])
data class PartEntity(
    var id: String,
    val number: Int,
    var idBudget: String,
    val idProduct: String,
    val quantity: Int,
    val discount: Double,
)