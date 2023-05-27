package com.invoice.contratista.data.source.local.entity.product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * # Producto
 * @param id ID del producto
 * @param description Descripción del bien o servicio como aparecerá en la factura
 * @param productKey Clave de producto/servicio, del catálogo del SAT.
 * **NOTA** Nosotros te proporcionamos una manera más conveniente de encontrarlo utilizando
 * nuestra herramienta de búsqueda de claves.
 *
 * @param price Precio por unidad del bien o servicio. **NOTA** Este valor representará el
 * precio con IVA incluído o sin él, dependiendo del valor de [.tax_included].
 *
 * @param taxIncluded Impuestos incluidos.
 *
 * Su valor puede ser:
 * - `true`: Indica que todos los impuestos aplicables
 * están incluídos en el precio (atributo price) y se
 * desglosarán automáticamente al emitir la factura.
 * - `false`: Indica que el atributo price no incluye
 * impuestos, por lo que aquellos impuestos a aplicar
 * se sumarán en el precio final.
 *
 * @param taxability Objeto de impuestos.
 *
 * Código que representa si el bien o servicio es objeto de impuesto o no. Este
 * atributo corresponde al campo "ObjetoImp" en el CFDI.
 *
 * Su valor puede ser:
 * - `01`: No objeto de impuesto.
 * - `02`: Sí objeto de impuesto.
 * - `03`: Sí objeto de impuesto, pero no obligado a desglose.
 *
 * Default
 * - `01` si el array [.taxes] está vacío
 * - `02` si el array [.taxes] tiene por lo menos un elemento.
 *
 * @param unitKey Clave de unidad de medida, del catálogo del SAT.
 *
 * - El valor por default `H87` (elemento) es la clave para representar una
 * pieza o unidad de venta (lápiz, cuaderno, televisión, etc).
 *
 * - Si la unidad de tu producto es kilogramos, litros, horas u otra unidad,
 * puedes encontrar la clave utilizando nuestra herramienta de búsqueda de claves.
 *
 * @param unitName Unidad de medida
 * @param sku Identificador de uso interno designado por la empresa. Puede tener cualquier valor
 *
 * - Palabra que representa la unidad de medida de tu producto. Debe estar relacionada con la
 * clave de unidad [.unit_key].
 *
 * @version 17/03/2022
 * @author Alejandra JA
 * @see <a href="https://www.facturapi.io/dashboard/tools/keys">Keys</a>
 * @see <a href="https://www.facturapi.io/dashboard/tools/keys">Keys</a>
 */
@Entity(tableName = "product_base")
data class ProductBaseEntity(
    @PrimaryKey(autoGenerate = false) var id: String,
    var description: String,
    @ColumnInfo(name = "product_key") var productKey: Int,
    @ColumnInfo(name = "tax_included") var taxIncluded: Boolean,
    var taxability: String,
    @ColumnInfo(name = "unit_key") var unitKey: String,
    @ColumnInfo(name = "unit_name") var unitName: String,
    var sku: String,
    val idProduct: String,
)