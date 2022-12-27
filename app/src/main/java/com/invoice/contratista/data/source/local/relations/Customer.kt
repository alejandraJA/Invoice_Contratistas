package com.invoice.contratista.data.source.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.invoice.contratista.data.source.local.entity.AddressEntity
import com.invoice.contratista.data.source.local.entity.CustomerEntity

/**
 * Objeto cliente completo
 * @param customer Datos generales del cliente.
 * @param address Dirección del cliente.
 */
data class Customer(
    @Embedded val customer: CustomerEntity?,
    @Relation(
        parentColumn = "id",
        entityColumn = "id_reference",
    )
    val address: AddressEntity?,
) {
    fun isNotEmpty() =
        !((customer != null) && (address != null) && customer.isEmpty() && address.isEmpty())
}