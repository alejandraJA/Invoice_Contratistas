package com.invoice.contratista.data.source.local.entity.event

import androidx.room.ColumnInfo
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
@Entity(tableName = "part", primaryKeys = ["id", "id_product"])
data class PartEntity(
    var id: String,
    val number: Int,
    @ColumnInfo(name = "id_budget") var idBudget: String,
    @ColumnInfo(name = "id_product") val idProduct: String,
    val quantity: Int,
    val discount: Double,
)