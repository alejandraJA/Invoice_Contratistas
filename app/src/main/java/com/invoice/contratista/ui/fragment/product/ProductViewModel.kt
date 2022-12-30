package com.invoice.contratista.ui.fragment.product

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.invoice.contratista.data.repository.local.ProductRepository
import com.invoice.contratista.ui.fragment.product.adapter.ProductItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {
    val products = MediatorLiveData<List<ProductItem>>().apply {
//        addSource(productRepository.getProductsForRecycler()) {
//            if (it.isNotEmpty()) value = it
//        }
    }
}