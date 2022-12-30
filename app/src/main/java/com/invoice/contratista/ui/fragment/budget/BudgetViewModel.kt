package com.invoice.contratista.ui.fragment.budget

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.data.repository.local.BudgetRepository
import com.invoice.contratista.data.repository.local.PartRepository
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
import com.invoice.contratista.ui.fragment.budget.adapter.PartItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BudgetViewModel @Inject constructor(
    private val budgetRepository: BudgetRepository,
    private val partRepository: PartRepository,
    private val utilsManager: UtilsManager
) : ViewModel() {

    fun setPart(idPart: String, idProduct: String) {
        utilsManager.setIdPart(idPart)
        utilsManager.setIdProduct(idProduct)
    }

    fun createPart() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                partRepository.createPart()
            }
        }
    }

    val parts = MediatorLiveData<List<PartItem>>().apply {
        addSource(partRepository.getPartsForRecycler()) {
            if (it.isNotEmpty()) value = it
        }
    }
    val budget = MediatorLiveData<BudgetData>().apply {
        addSource(budgetRepository.findById()) { budget ->
            if (budget != null) value = budget
        }
    }
}