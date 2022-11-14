package com.invoice.contratista.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.invoice.contratista.data.local.entity.event.BudgetEntity
import com.invoice.contratista.data.local.relations.Budget

@Dao
interface BudgetDao {
    /**
     * Metodo para insertar una cotización.
     * @param budgetEntity Objeto cotización
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setBudget(budgetEntity: BudgetEntity)

    /**
     * Metodo para obtener el objeto budget completo
     * @param id Identificador de la cotizacion al que pertenece el seguimiento de la cotización.
     * @return Objeto de tipo [LiveData] que contiene un objeto de tipo [Budget]
     */
    @Transaction
    @Query("SELECT * FROM budget WHERE id == :id LIMIT 1")
    fun getBudget(id: String): LiveData<Budget>

    /**
     * Metodo para obtener todas las cotizaciones completas
     * @return Lista de objetos de tipo [Budget]
     */
    @Transaction
    @Query("SELECT * FROM budget")
    fun getBudgets(): LiveData<List<Budget>>

    @Query("SELECT number FROM budget ORDER BY number DESC LIMIT 1")
    fun getNumberBudget(): Int

    @Query("SELECT * FROM budget WHERE id_event == :idEvent ORDER BY number ASC")
    fun getBudgetsEntity(idEvent: String): LiveData<List<BudgetEntity>>

}