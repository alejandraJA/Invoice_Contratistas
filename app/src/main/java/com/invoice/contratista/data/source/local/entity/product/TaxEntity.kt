package com.invoice.contratista.data.source.local.entity.product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.invoice.contratista.data.source.local.relations.Product

/**
 * # Impuestos
 * Lista de impuestos que deberán aplicarse a este producto.
 *
 * - Si el parámetro se omite o es nulo, se guardará con un elemento que
 * representa al *IVA trasladado 16%*, que es el impuesto más común.
 * - En caso de mandar explícitamente un arreglo vacío, se entiende que
 * el producto **está exento de impuestos**.
 *
 * @param id Identificador del impuestos
 * @param type Tipo de impuesto. **NOTA** Sus valores pueden ser *IVA*, *ISR* y *IEPS*.
 * @param rate Tasa del impuesto. Default *0.16*
 * @param factor Tipo factor. **NOTA** Sus valores pueden ser *Tasa*, *Cuota* y *Exento*.
 * @param withholding Indica si se trata de un impuesto retenido *true*, o un impuesto trasladado *false*.
 * @param idProduct Referencia a la tabla [ProductEntity]
 *
 * @author Alejandra JA - 17/03/2022
 * @see Product
 */
@Entity(tableName = "tax")
data class TaxEntity(
    @PrimaryKey(autoGenerate = true) var id: Long,
    var type: String? = null,
    var rate: Double = 0.0,
    var factor: String? = null,
    var withholding: Boolean = false,
    @ColumnInfo(name = "id_product") var idProduct: String,
    var localTax: Boolean
)
