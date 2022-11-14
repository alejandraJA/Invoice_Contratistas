package com.invoice.contratista.utils

object StatesUtils {
    fun String.getStatusBudget() = when (this) {
        Constants.BudgetStatus.Pendiente.name -> Constants.BudgetStatus.Pendiente
        Constants.BudgetStatus.Espera.name -> Constants.BudgetStatus.Espera
        Constants.BudgetStatus.Cancelado.name -> Constants.BudgetStatus.Cancelado
        Constants.BudgetStatus.Autorizado.name -> Constants.BudgetStatus.Autorizado
        else -> Constants.BudgetStatus.Pendiente
    }

    fun String.getStateSchedule() = when (this) {
        Constants.StateSchedule.Pendiente.name -> Constants.StateSchedule.Pendiente
        Constants.StateSchedule.Atendido.name -> Constants.StateSchedule.Atendido
        else -> Constants.StateSchedule.Pendiente
    }
}