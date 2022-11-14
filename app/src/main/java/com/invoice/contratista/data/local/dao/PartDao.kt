package com.invoice.contratista.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.invoice.contratista.data.local.entity.event.PartEntity
import com.invoice.contratista.data.local.relations.Budget
import com.invoice.contratista.data.local.relations.Part

@Dao
interface PartDao {

    /**
     * Metodo para insertar una partida para la cotización.
     * @param partEntity Objeto partida
     *
     * @see Budget
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setPart(partEntity: PartEntity)

    /**
     * Metodo para obtener la partida de una cotización
     * @param idBudget id que hace referencia al id de la cotización
     * @return Objeto de tipo [LiveData] que contiene una lista de tipo [Part]
     */
    @Transaction
    @Query("SELECT * FROM part WHERE idBudget == :idBudget")
    fun getParts(idBudget: String): LiveData<List<Part>>

    /**
     * Metodo para obtener una partida con su propio id.
     * @param idPart id de la partida que retorna.
     * @return Objeto de tipo [LiveData] que contiene un objeto de tipo [Part]
     */
    @Transaction
    @Query("SELECT * FROM part WHERE id == :idPart LIMIT 1")
    fun getPart(idPart: String): LiveData<Part>

    @Query("SELECT number FROM part WHERE idBudget == :idBudget ORDER BY number DESC LIMIT 1")
    fun getNumberOfPart(idBudget: String): Int

}