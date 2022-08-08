package com.invoice.contratista.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * # Clase Clientes
 *
 * @param id ID del cliente
 * @param legal_name Nombre fiscal o razón social del cliente
 * @param tax_id RFC o Identificacion tributaria.
 * - En clientes de México contiene el RFC del cliente.
 * - Para extranjeros es opcional y representa el número de registro de identificacón
 * tributaria, es decir, el equivalente al RFC en el país del cliente.
 * @param tax_system Clave del régimen fiscal del cliente.
 * **NOTA** Requerido para clientes nacionales.
 * @param email Dirección de correo electrónico al cual enviar las facturas generadas
 * @param phone Teléfono del cliente
 *
 * @author Alejandra JA -16/03/2022
 */
@Entity(tableName = "customer")
data class CustomerEntity(
    @PrimaryKey(autoGenerate = false) var id: String,
    var legal_name: String,
    var tax_id: String,
    var tax_system: String,
    var email: String,
    var phone: String,
) {
    fun isEmpty() = (legal_name.isEmpty() && tax_id.isEmpty() && tax_system.isEmpty() &&
            email.isEmpty() && phone.isEmpty())
}