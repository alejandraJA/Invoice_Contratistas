package com.invoice.contratista.data.source.local.relations.event

import androidx.room.Embedded
import androidx.room.Relation
import com.invoice.contratista.data.source.local.entity.event.BudgetEntity

/**
 * 1. EventEntity y BudgetEntity:
 * - La entidad EventEntity tiene una relación uno a muchos con BudgetEntity, ya que un evento puede
 * tener varios presupuestos asociados, pero un presupuesto pertenece a un solo evento. La relación
 * se establece mediante el campo "idEvent" de BudgetEntity, que hace referencia al campo "id" de
 * EventEntity.
 *
 * 2. EventEntity y NoteEntity:
 * - La entidad EventEntity tiene una relación uno a muchos con NoteEntity, ya que un evento puede tener varias notas asociadas, pero una nota pertenece a un solo evento. La relación se establece mediante el campo "idEvent" de NoteEntity, que hace referencia al campo "id" de EventEntity.
 *
 * 3. BudgetEntity y PartEntity:
 * - La entidad BudgetEntity tiene una relación uno a muchos con PartEntity, ya que un presupuesto puede tener varias partes asociadas, pero una parte pertenece a un solo presupuesto. La relación se establece mediante el campo "idBudget" de PartEntity, que hace referencia al campo "id" de BudgetEntity.
 *
 * 4. PartEntity y ReservedEntity:
 * - La entidad PartEntity tiene una relación uno a muchos con ReservedEntity, ya que una parte puede tener varias reservas asociadas, pero una reserva pertenece a una sola parte. La relación se establece mediante los campos "id" y "reservedId" de PartEntity, que hacen referencia a los campos "idPart" y "idReserved" de ReservedEntity respectivamente.
 *
 * 5. EventEntity y ScheduleEntity:
 * - La entidad EventEntity tiene una relación uno a muchos con ScheduleEntity, ya que un evento puede tener varios horarios asociados, pero un horario pertenece a un solo evento. La relación se establece mediante el campo "idEvent" de ScheduleEntity, que hace referencia al campo "id" de EventEntity.
 */
data class BudgetWithParts(
    @Embedded val budget: BudgetEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "budget_id"
    )
    val parts: List<PartWithReserved>
)