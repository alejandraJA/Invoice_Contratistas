package com.invoice.contratista.ui.fragment.customer.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.data.local.relations.Customer
import com.invoice.contratista.domain.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CreateCustomerViewModel @Inject constructor(private val dataRepository: DataRepository)
    : ViewModel() {
    fun createCustomer(customer: Customer) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dataRepository.createCustomer(customer)
            }
        }
    }
}