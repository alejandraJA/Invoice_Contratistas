package com.invoice.contratista.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.invoice.contratista.data.local.entity.AddressEntity

@Dao
interface AddressDao {
    /**
     * Metodo para insertar una dirección.
     * @param addressEntity Objeto dirección
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setAddress(addressEntity: AddressEntity)

    @Query(
        "UPDATE address " +
                "SET street = :street," +
                "exterior = :exterior," +
                "interior = :interior," +
                "neighborhood = :neighborhood," +
                "city = :city," +
                "municipality = :municipality," +
                "zip = :zip," +
                "state = :state " +
                "WHERE idCustomer == :idSchedule"
    )
    fun updateAddress(
        street: String,
        exterior: String,
        interior: String,
        neighborhood: String,
        city: String,
        municipality: String,
        zip: String,
        state: String,
        idSchedule: String
    )

    @Query("SELECT * FROM address WHERE idCustomer == :idSchedule")
    fun getAddress(idSchedule: String): LiveData<AddressEntity>

    @Query("DELETE FROM address")
    fun deleteAddress();
}