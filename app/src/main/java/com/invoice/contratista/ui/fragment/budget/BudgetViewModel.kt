package com.invoice.contratista.ui.fragment.budget

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.invoice.contratista.data.local.relations.Budget
import com.invoice.contratista.data.local.relations.Part
import com.invoice.contratista.data.shared_preferences.UtilsManager
import com.invoice.contratista.domain.BudgetRepository
import com.invoice.contratista.domain.PartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BudgetViewModel @Inject constructor(
    private val budgetRepository: BudgetRepository,
    private val partRepository: PartRepository,
    private val utilsManager: UtilsManager
) : ViewModel() {

    fun setPart(idPart: String) = utilsManager.setIdPart(idPart)

    val parts = MediatorLiveData<List<Part>>().apply {
        addSource(partRepository.getParts()) {
            if (it.isNotEmpty()) value = it
        }
    }
    val budget = MediatorLiveData<Budget>().apply {
        addSource(budgetRepository.getBudget()) { budget ->
            if (budget != null) value = budget
        }
    }
}