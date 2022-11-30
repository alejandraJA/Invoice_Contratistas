package com.invoice.contratista.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.invoice.contratista.data.source.local.entity.event.BudgetEntity
import com.invoice.contratista.data.source.local.relations.Budget
import com.invoice.contratista.ui.fragment.budget.BudgetData

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

    @Query(
        "SELECT number, date, subtotal, subtotal + sumTax - restTax AS total, totalGain " +
                "FROM ( " +
                "    SELECT number, date, IFNULL(t.sumTax, 0) AS sumTax, IFNULL(t.restTax, 0) AS restTax, SUM(a.amount) AS subtotal, a.totalGain " +
                "    FROM budget, ( " +
                "        SELECT SUM(CASE WHEN withholding == 0 THEN  tax ELSE 0 END) AS sumTax, SUM(CASE WHEN withholding == 1 THEN  tax ELSE 0 END) AS restTax  " +
                "        FROM ( " +
                "            SELECT CASE WHEN t.factor != 'Cuota' THEN ((pr.price * p.quantity) - p.discount) * t.rate ELSE t.rate * p.quantity END AS tax, t.withholding " +
                "            FROM part AS p, product AS pr, tax AS t  " +
                "            WHERE p.idBudget == :idBudget AND pr.id == p.idProduct AND pr.id == t.idProduct AND t.factor != 'Exento' " +
                "        ) " +
                "    ) AS t, ( " +
                "        SELECT (pr.price * p.quantity) - p.discount AS amount, (((pr.price - p.discount) * pr.gain) * p.quantity) AS totalGain " +
                "        FROM part p JOIN product pr ON p.idProduct == pr.id " +
                "        WHERE p.idBudget == :idBudget " +
                "    ) AS a " +
                "    WHERE id == :idBudget " +
                ")"
    )
    fun findById(idBudget: String): LiveData<BudgetData>

}