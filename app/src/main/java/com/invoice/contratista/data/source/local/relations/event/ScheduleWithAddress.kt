package com.invoice.contratista.data.source.local.relations.event

import androidx.room.Embedded
import androidx.room.Relation
import com.invoice.contratista.data.source.local.entity.AddressEntity
import com.invoice.contratista.data.source.local.entity.event.ScheduleEntity

data class ScheduleWithAddress(
    @Embedded val schedule: ScheduleEntity,
    @Relation(
        parentColumn = "id_address",
        entityColumn = "id"
    )
    val address: AddressEntity
)