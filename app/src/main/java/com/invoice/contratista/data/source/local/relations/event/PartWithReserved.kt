package com.invoice.contratista.data.source.local.relations.event

import androidx.room.Embedded
import androidx.room.Relation
import com.invoice.contratista.data.source.local.entity.event.PartEntity
import com.invoice.contratista.data.source.local.entity.event.ReservedEntity

data class PartWithReserved(
    @Embedded val part: PartEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id_part"
    )
    val reserved: List<ReservedEntity>
)