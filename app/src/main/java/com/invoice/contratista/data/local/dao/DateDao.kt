package com.invoice.contratista.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.invoice.contratista.data.local.entity.DateEntity

@Dao
interface DateDao {

    /**
     * Metodo para obtener las fechas del historial de un evento
     * @return Lista de objetos de tipo [DateEntity]
     */
    @Query("SELECT * FROM date WHERE idReference == :idEvent")
    fun getDates(idEvent: String): LiveData<List<DateEntity>>

    /**
     * Metodo para insertar una fecha
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setDate(dateEntity: DateEntity)

}