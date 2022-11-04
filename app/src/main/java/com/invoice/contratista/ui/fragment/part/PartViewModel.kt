package com.invoice.contratista.ui.fragment.part

import androidx.lifecycle.*
import com.invoice.contratista.data.local.entity.event.PartEntity
import com.invoice.contratista.data.local.relations.Product
import com.invoice.contratista.data.shared_preferences.UtilsManager
import com.invoice.contratista.domain.PartRepository
import com.invoice.contratista.domain.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PartViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val partRepository: PartRepository,
    private val utilsManager: UtilsManager
) : ViewModel() {

    val oldPart = MediatorLiveData<UpdatePart>().apply {
        if (utilsManager.getIdPart().isNotBlank()) {
            addSource(partRepository.getPart()) {
                if (it != null) {
                    val updatePart = UpdatePart()
                    updatePart.partEntity = it.partEntity!!
                    updatePart.product = it.product!!
                    value = updatePart
                }
            }
        }
    }

    val newPart = MediatorLiveData<NewPart>().apply {
        val newPart = NewPart()
        if (utilsManager.getIdPart().isBlank()) {
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    newPart.budgetNumber = partRepository.getNumber()
                    addSource(productRepository.getProductsForSelector()) {
                        if (it.isNotEmpty()) {
                            newPart.productsList = it
                            value = newPart
                        }
                    }
                }
            }
        }
    }

    fun getProduct(id: String): MediatorLiveData<Product> {
        val product = MediatorLiveData<Product>().apply {
            addSource(productRepository.getProduct(id)) {
                if (it?.product != null) value = it
            }
        }
        return product
    }

    fun setPart(partEntity: PartEntity) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                partRepository.setPart(partEntity)
            }
        }
    }
}