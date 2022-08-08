package com.invoice.contratista.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * # Clase Direccion
 *
 * @param street Nombre de la calle
 * @param exterior Número del exterior
 * @param interior Número del interior
 * @param neighborhood Colonia
 * @param city Ciudad
 * @param municipality Municipio o delegacion
 * @param zip Codigo postal
 * @param state Estado
 * - Si el país es México ("MEX"), contiene el nombre del Estado o Entidad
 * Federativa. Para extranjeros contiene el código de Estado de acuerdo al estándar ISO 3166-2,
 * que puedes consultar en nuestro Catalogo de estados.
 * @param country País
 * - Código de país acorde al estandar ISO 3166-1 alpha-3, del
 * Catalogo de Países.
 * @param idCustomer Id de referencia a la tabla Customer
 *
 *
 * @author Alejandra JA
 * @version 16/03/2022
 * @see <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-3">ISO 3166-1 alpha-3</a>
 * @see <a href="https://www.facturapi.io/dashboard/catalogs/country">Catalogo de paises</a>
 * @see <a href="https://en.wikipedia.org/wiki/ISO_3166-2">ISO 3166-2</a>
 * @see <a href="https://www.facturapi.io/dashboard/catalogs/state">Catalogo de estados</a>
 * @see CustomerEntity
 */
@Entity(tableName = "address")
data class AddressEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    var street: String,
    var exterior: String,
    var interior: String,
    var neighborhood: String,
    var city: String,
    var municipality: String,
    var zip: String,
    var state: String,
    var country: String,
    var idCustomer: String
) {
    fun isEmpty() = (street.isEmpty() && exterior.isEmpty() && interior.isEmpty() &&
            neighborhood.isEmpty() && city.isEmpty() && municipality.isEmpty() &&
            zip.isEmpty() && state.isEmpty())
}
