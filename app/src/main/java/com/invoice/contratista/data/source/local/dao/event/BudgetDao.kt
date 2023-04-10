package com.invoice.contratista.data.source.local.dao.event

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

    @Query("SELECT B.number\n" +
            "     , B.date\n" +
            "     , IFNULL(TOTALS.subtotal, 0)                                  AS subtotal\n" +
            "     , IFNULL(TOTALS.subtotal + TOTALS.sumTax - TOTALS.restTax, 0) AS total\n" +
            "     , IFNULL(TOTALS.totalGain, 0)                                 AS totalGain\n" +
            "FROM budget AS B,\n" +
            "     (SELECT IFNULL(t.sumTax, 0)  AS sumTax\n" +
            "           , IFNULL(t.restTax, 0) AS restTax\n" +
            "           , SUM(a.amount)        AS subtotal\n" +
            "           , a.totalGain\n" +
            "      FROM budget,\n" +
            "           (SELECT SUM(CASE WHEN withholding = 0 THEN tax ELSE 0 END) AS sumTax,\n" +
            "                   SUM(CASE WHEN withholding = 1 THEN tax ELSE 0 END) AS restTax\n" +
            "            FROM (SELECT CASE\n" +
            "                             WHEN T.factor != 'Cuota' THEN ((PR.unit_price * P.quantity) - P.discount) * T.rate\n" +
            "                             ELSE T.rate * p.quantity END AS tax,\n" +
            "                         T.withholding\n" +
            "                  FROM part AS P\n" +
            "                           JOIN tax AS T ON T.factor != 'Exento'\n" +
            "                           JOIN reserved AS R ON R.id = P.reserved_id AND R.product_id = T.product_id\n" +
            "                           join price PR ON PR.id = R.price_id\n" +
            "                  WHERE P.budget_id = :idBudget) as tw) AS t,\n" +
            "           (SELECT SUM(((pr.unit_price * p.quantity) - p.discount))               AS amount\n" +
            "                 , SUM((((pr.unit_price - C.unit_cost) * p.quantity) - discount)) AS totalGain\n" +
            "            FROM part AS P\n" +
            "                     JOIN reserved AS R ON P.reserved_id = R.id\n" +
            "                     JOIN price PR ON PR.id = R.price_id\n" +
            "                     LEFT JOIN product_inventory AS PRI ON PRI.product_id = PR.product_id\n" +
            "                     LEFT JOIN cost AS C ON PRI.id = C.product_inventory_id\n" +
            "            WHERE p.budget_id = :idBudget) AS a\n" +
            "      WHERE id = :idBudget\n" +
            "      GROUP BY t.sumTax, a.totalGain) AS TOTALS\n" +
            "WHERE id = :idBudget")
    fun findById(idBudget: String): LiveData<BudgetData>

}