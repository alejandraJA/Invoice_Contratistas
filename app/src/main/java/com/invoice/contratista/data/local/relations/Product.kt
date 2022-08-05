package com.invoice.contratista.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.invoice.contratista.data.local.entity.product.LocalTaxEntity
import com.invoice.contratista.data.local.entity.product.ProductEntity
import com.invoice.contratista.data.local.entity.product.TaxEntity

/**
 * Objeto Producto completo
 * @param product Objeto de tipo [ProductEntity] que contiene los datos generales del producto.
 * @param localTaxes Lista de objetos de tipo [LocalTaxEntity] que contiene los impuestos locales
 * aplicados al [product].
 * @param taxes Lista de objetos de tipo [TaxEntity] que contiene la lista de impuestos aplicados
 * aplicados al [product]
 */
data class Product (
    @Embedded val product: ProductEntity?,
    @Relation(
        parentColumn = "id",
        entityColumn = "idProduct",
    )
    val localTaxes: List<LocalTaxEntity>?,
    @Relation(
        parentColumn = "id",
        entityColumn = "idProduct",
    )
    val taxes: List<TaxEntity>?,
)