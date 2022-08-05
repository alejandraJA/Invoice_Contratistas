package com.invoice.contratista.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.invoice.contratista.data.local.entity.BudgetEntity
import com.invoice.contratista.data.local.entity.CustomerEntity
import com.invoice.contratista.data.local.entity.event.PartEntity

/**
 * Objeto que obtiene todas las relaciones correspondientes a la cotización.
 * @param budgetEntity Objeto de tipo [BudgetEntity] que contiene los datos generales de la cotización.
 * @param parts Lista de objetos de tipo [Part] que contiene las relaciones de las partidas completas.
 *
 * @see PartEntity
 */
data class Budget(
    @Embedded val budgetEntity: BudgetEntity?,
    @Relation(
        entity = PartEntity::class,
        parentColumn = "id",
        entityColumn = "idBudget"
    )
    val parts: List<Part>?,
    @Relation(
        parentColumn = "id_customer",
        entityColumn = "id",
    )
    val customer: CustomerEntity?,
)