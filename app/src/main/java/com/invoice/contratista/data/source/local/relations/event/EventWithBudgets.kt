package com.invoice.contratista.data.source.local.relations.event

import androidx.room.Embedded
import androidx.room.Relation
import com.invoice.contratista.data.source.local.entity.DateEntity
import com.invoice.contratista.data.source.local.entity.EventEntity
import com.invoice.contratista.data.source.local.entity.event.NoteEntity

data class EventWithBudgets(
    @Embedded val event: EventEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id_event"
    )
    val budgets: List<BudgetWithParts>,
    @Relation(
        parentColumn = "id",
        entityColumn = "id_event"
    )
    val notes: List<NoteEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "id_event"
    )
    val schedules: List<ScheduleWithAddress>,
    @Relation(
        parentColumn = "id",
        entityColumn = "id_reference",
        entity = DateEntity::class
    )
    val dates: List<DateEntity>
)

