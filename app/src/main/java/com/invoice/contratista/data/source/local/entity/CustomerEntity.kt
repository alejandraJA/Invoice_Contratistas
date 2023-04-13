package com.invoice.contratista.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * # Clase Clientes
 *
 * @param id ID del cliente
 * @param legalName Nombre fiscal o razón social del cliente
 * @param idTax RFC o Identificacion tributaria.
 * - En clientes de México contiene el RFC del cliente.
 * - Para extranjeros es opcional y representa el número de registro de identificacón
 * tributaria, es decir, el equivalente al RFC en el país del cliente.
 * @param taxSystem Clave del régimen fiscal del cliente.
 * **NOTA** Requerido para clientes nacionales.
 * @param email Dirección de correo electrónico al cual enviar las facturas generadas
 * @param phone Teléfono del cliente
 *
 * @author Alejandra JA -16/03/2022
 */
@Entity(tableName = "customer")
data class CustomerEntity(
    @PrimaryKey(autoGenerate = false) var id: String,
    @ColumnInfo(name = "legal_name") var legalName: String,
    @ColumnInfo(name = "id_tax") var idTax: String,
    @ColumnInfo(name = "tax_system") var taxSystem: String,
    var email: String,
    var phone: String,
) {
    fun isEmpty() = (legalName.isEmpty() && idTax.isEmpty() && taxSystem.isEmpty() &&
            email.isEmpty() && phone.isEmpty())
}