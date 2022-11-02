package com.invoice.contratista.ui.fragment.part

import androidx.lifecycle.*
import com.invoice.contratista.data.local.entity.event.PartEntity
import com.invoice.contratista.data.local.relations.Product
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
    private val partRepository: PartRepository
) : ViewModel() {

    fun getNumber(): LiveData<Int> {
        val number = MutableLiveData<Int>()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                number.postValue(partRepository.getNumber())
            }
        }
        return number
    }

    val listProduct = MediatorLiveData<List<ProductsItem>>().apply {
        addSource(productRepository.getProductsForSelector()) {
            if (it.isNotEmpty()) value = it
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