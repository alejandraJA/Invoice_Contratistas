package com.invoice.contratista.data.source.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.invoice.contratista.data.source.local.entity.CustomerEntity
import com.invoice.contratista.data.source.local.entity.EventEntity

data class Event(
    @Embedded val eventEntity: EventEntity,
    @Relation(
        entity = CustomerEntity::class,
        parentColumn = "id_customer",
        entityColumn = "id",
    )
    val customer: Customer
)