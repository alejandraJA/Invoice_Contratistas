package com.invoice.contratista.data.source.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.invoice.contratista.data.source.local.entity.event.PartEntity
import com.invoice.contratista.data.source.local.entity.event.ReservedEntity

/**
 * Objeto Partida completo
 * @param partEntity Objeto de tipo [PartEntity] que contiene los datos generales de la partida.
 * @param reservedEntity Objeto de tipo [Product] que contiene las relación del Producto completas.
 */
data class Part(
    @Embedded val partEntity: PartEntity?,
    @Relation(
        entity = ReservedEntity::class,
        parentColumn = "reserved_id",
        entityColumn = "id"
    )
    val reservedEntity: ReservedEntity?,
)