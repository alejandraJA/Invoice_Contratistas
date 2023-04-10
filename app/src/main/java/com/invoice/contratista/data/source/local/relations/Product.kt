package com.invoice.contratista.data.source.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.invoice.contratista.data.source.local.entity.product.ProductBaseEntity
import com.invoice.contratista.data.source.local.entity.product.TaxEntity

/**
 * Objeto Producto completo
 * @param product Objeto de tipo [ProductBaseEntity] que contiene los datos generales del producto.
 * @param localTaxes Lista de objetos de tipo [LocalTaxEntity] que contiene los impuestos locales
 * aplicados al [product].
 * @param taxes Lista de objetos de tipo [TaxEntity] que contiene la lista de impuestos aplicados
 * aplicados al [product]
 */
data class Product (
    @Embedded val product: ProductBaseEntity?,
    @Relation(
        parentColumn = "id",
        entityColumn = "product_id",
    )
    val taxes: List<TaxEntity>?,
)

