package com.invoice.contratista.ui.fragment.part

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.data.repository.local.PartRepository
import com.invoice.contratista.data.repository.local.ProductBaseRepository
import com.invoice.contratista.data.repository.local.TaxRepository
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
import com.invoice.contratista.ui.fragment.part.adapter.TaxItem
import com.invoice.contratista.ui.fragment.part.data.ProductItem
import com.invoice.contratista.ui.fragment.part.data.ProductPart
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PartViewModel @Inject constructor(
    private val productBaseRepository: ProductBaseRepository,
    private val partRepository: PartRepository,
    private val taxRepository: TaxRepository,
    private val utilsManager: UtilsManager,
) : ViewModel() {

    val taxes = MediatorLiveData<List<TaxItem>>()
    val product = MediatorLiveData<ProductPart>()

    val productItem = MediatorLiveData<List<ProductItem>>().apply {
        addSource(productBaseRepository.getProductsForSelector()) {
            if (it.isNotEmpty()) value = it
        }
    }

    init {
        loadProduct()
    }

    private fun loadProduct() {
        product.apply {
            addSource(productBaseRepository.getProductPart()) {
                if (it != null) value = it
            }
        }
        taxes.apply {
            addSource(taxRepository.getParts()) {
                if (it.isNotEmpty()) value = it
            }
        }
    }

    fun updateQuantity(quantity: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                partRepository.updateQuantity(quantity)
            }
        }
    }

    fun updateDiscount(discount: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                partRepository.updateDiscount(discount)
            }
        }
    }

    fun updateProduct(idProduct: String) {
        utilsManager.setIdProduct(idProduct)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                partRepository.updateProduct(idProduct)
            }
        }
        loadProduct()
    }

}