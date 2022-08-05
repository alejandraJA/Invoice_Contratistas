package com.invoice.contratista.data.local.entity.product

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.invoice.contratista.data.local.relations.Product

/**
 * # Impuestos locales
 * Arreglo de impuestos locales (estatales o municipales), en caso de haberlos.
 *
 * @param id Identificador del impuestos
 * @param rate Tasa del impuesto
 * @param type Nombre del impuesto. Texto libre
 * @param withholding Indica si se trata de un impuesto retenido `true`, o un
 * impuesto trasladado `false`
 * @param idProduct Referencia a la tabla [ProductEntity]
 *
 * @version 17/03/2022
 * @author Alejandra JA
 * @see [Product]
 */
@Entity(tableName = "local_tax")
data class LocalTaxEntity(
    @PrimaryKey(autoGenerate = true) var id: Long,
    var rate: Int,
    var type: String,
    var withholding: Boolean,
    val idProduct: String
)