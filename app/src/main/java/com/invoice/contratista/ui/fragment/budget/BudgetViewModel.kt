package com.invoice.contratista.ui.fragment.budget

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.invoice.contratista.data.local.relations.Budget
import com.invoice.contratista.domain.BudgetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BudgetViewModel @Inject constructor(
    private val budgetRepository: BudgetRepository,
) : ViewModel() {
    val budget = MediatorLiveData<Budget>().apply {
        addSource(budgetRepository.getBudget()) { budget ->
            if (budget != null) value = budget
        }
    }
}