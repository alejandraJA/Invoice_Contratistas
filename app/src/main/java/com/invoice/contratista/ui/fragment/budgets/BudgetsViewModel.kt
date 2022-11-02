package com.invoice.contratista.ui.fragment.budgets

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.data.local.entity.event.BudgetEntity
import com.invoice.contratista.data.shared_preferences.UtilsManager
import com.invoice.contratista.domain.BudgetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BudgetsViewModel @Inject constructor(
    private val budgetRepository: BudgetRepository,
    private val utilsManager: UtilsManager
    ) :
    ViewModel() {
    fun setBudget() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                budgetRepository.createBudget()
            }
        }
    }
    fun setIdBudget(idBudget: String) = utilsManager.setIdBudget(idBudget)

    val budget = MediatorLiveData<List<BudgetEntity>>().apply {
        addSource(budgetRepository.getBudgets()) {
            if (it.isNotEmpty()) value = it
        }
    }
}