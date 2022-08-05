package com.invoice.contratista.data.local.entity.event

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * # Objeto Partida
 *
 * @param id Identificador para la partida.
 * @param number Número de la partida.
 * @param idBudget Identificador de la cotización a la que pertenece la partida.
 * @param idProduct Identificador del producto al que hace referencia.
 * @param quantity Cantidad.
 * @param discount Descuento aplicado a la partida.
 * @param custom_keys Números de pedimento aduanal asociados a esta parte.
 * @param description Descripsión
 */
@Entity(tableName = "part", primaryKeys = ["id", "idProduct"])
data class PartEntity(
    val id: Long,
    val number: Int,
    val idBudget: Long,
    val idProduct: String,
    val quantity: Int,
    val discount: Int,
    val custom_keys: String,
    val description: String,
)