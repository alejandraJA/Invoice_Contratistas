package com.invoice.contratista.ui.fragment.budget

import androidx.lifecycle.ViewModel
import com.invoice.contratista.domain.BudgetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BudgetViewModel @Inject constructor(
    private val budgetRepository: BudgetRepository,
) : ViewModel() {
    fun insertIdBudget(id: String) = budgetRepository.setIdBudget(id)
}