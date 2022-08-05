package com.invoice.contratista.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.invoice.contratista.data.local.entity.event.PartEntity
import com.invoice.contratista.data.local.entity.product.ProductEntity

/**
 * Objeto Partida completo
 * @param partEntity Objeto de tipo [PartEntity] que contiene los datos generales de la partida.
 * @param product Objeto de tipo [Product] que contiene las relación del Producto completas.
 */
data class Part(
    @Embedded val partEntity: PartEntity?,
    @Relation(
        entity = ProductEntity::class,
        parentColumn = "idProduct",
        entityColumn = "id"
    )
    val product: Product?,
)