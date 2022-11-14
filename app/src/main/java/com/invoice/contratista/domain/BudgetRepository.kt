package com.invoice.contratista.domain

import com.invoice.contratista.data.local.dao.Dao
import com.invoice.contratista.data.local.entity.event.BudgetEntity
import com.invoice.contratista.data.local.relations.Budget
import com.invoice.contratista.data.shared_preferences.UtilsManager
import com.invoice.contratista.utils.Constants
import com.invoice.contratista.utils.DateUtils.getDateComplete
import java.util.*
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
            with(dao) {
                setBudget(budget.budgetEntity)
                if (budget.parts != null) budget.parts.forEach {
                    if (it.partEntity != null) setPart(it.partEntity)
                }
            }
        }
    }

    fun createBudget() {
        val number = dao.getNumberBudget() + 1
        val budgetEntity = BudgetEntity(
            "${UUID.randomUUID()}$number",
            number,
            utilsManager.getIdCustomer(),
            utilsManager.getIdEvent(),
            Date().getDateComplete(),
            "",
            "",
            Constants.BudgetStatus.Pendiente.name
        )
        dao.setBudget(budgetEntity)
    }

    /**
     * Metodo para obtener una cotización
     * @return Objeto de tipo [Budget]
     */
    fun getBudget() = dao.getBudget(utilsManager.getIdBudget())

    fun getBudgets() = dao.getBudgetsEntity(utilsManager.getIdEvent())

}