package com.invoice.contratista.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * # Clase Clientes
 *
 * @param id ID del cliente
 * @param created_at Fecha de registro
 * @param livemode Modo de trabajo
 * - Si el valor es `true`, indica que el objeto fue creado en ambiente Live; o si es `false`,
 * en ambiente Test.
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
    var created_at: String,
    var livemode: Boolean,
    var legal_name: String,
    var tax_id: String,
    var tax_system: String,
    var email: String,
    var phone: String,
)