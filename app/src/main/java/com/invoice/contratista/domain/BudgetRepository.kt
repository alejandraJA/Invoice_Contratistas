package com.invoice.contratista.domain

import com.invoice.contratista.data.local.dao.Dao
import com.invoice.contratista.data.local.relations.Budget
import com.invoice.contratista.data.shared_preferences.UtilsManager
import javax.inject.Inject

class BudgetRepository @Inject constructor(
    private val dao: Dao,
    private val utilsManager: UtilsManager
) {

    /**
     * Metodo para crear cotizaciones en la base de datos local
     * @param budget Objeto de tipo [Budget]
     */
    fun createBudget(budget: Budget) {
        if (budget.budgetEntity != null) {
            dao.setBudget(budget.budgetEntity)
            if (budget.parts != null) budget.parts.forEach {
                if (it.partEntity != null) dao.setPart(it.partEntity)
            }
        }
    }

    /**
     * Metodo para obtener una cotización
     * @return Objeto de tipo [Budget]
     */
    fun getBudget() = dao.getBudget(utilsManager.getIdEvent())

    /**
     * Metodo para guardar el id de la cotización selecccionada
     */
    fun setIdBudget(id: String) = utilsManager.setIdBudget(id)


}