package com.invoice.contratista.data.repository

import com.invoice.contratista.data.source.local.dao.BudgetDao
import com.invoice.contratista.data.source.local.dao.PartDao
import com.invoice.contratista.data.source.local.entity.event.BudgetEntity
import com.invoice.contratista.data.source.local.relations.Budget
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
import com.invoice.contratista.utils.Constants
import com.invoice.contratista.utils.DateUtils.getDateComplete
import java.util.Date
import java.util.UUID
import javax.inject.Inject

class BudgetRepository @Inject constructor(
    private val budgetDao: BudgetDao,
    private val partDao: PartDao,
    private val utilsManager: UtilsManager
) {

    /**
     * Metodo para crear cotizaciones en la base de datos local
     * @param budget Objeto de tipo [Budget]
     */
    fun createBudget(budget: Budget) {
        if (budget.budgetEntity != null) {
            with(budgetDao) {
                setBudget(budget.budgetEntity)
                if (budget.parts != null) budget.parts.forEach {
                    if (it.partEntity != null) partDao.setPart(it.partEntity)
                }
            }
        }
    }

    fun createBudget() {
        val number = budgetDao.getNumberBudget() + 1
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
        budgetDao.setBudget(budgetEntity)
    }

    /**
     * Metodo para obtener una cotización
     * @return Objeto de tipo [Budget]
     */

    fun getBudgets() = budgetDao.getBudgetsEntity(utilsManager.getIdEvent())

    fun findById() = budgetDao.findById(utilsManager.getIdBudget())

}