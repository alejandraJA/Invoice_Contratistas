package com.invoice.contratista.ui.fragment.budgets

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.invoice.contratista.data.local.entity.event.BudgetEntity
import com.invoice.contratista.domain.BudgetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BudgetsViewModel @Inject constructor(private val budgetRepository: BudgetRepository) :
    ViewModel() {
    val budget = MediatorLiveData<List<BudgetEntity>>().apply {
        addSource(budgetRepository.getBudgets()) {
            if (it.isNotEmpty()) value = it
        }
    }
}