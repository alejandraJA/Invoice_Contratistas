package com.invoice.contratista.ui.fragment.customer.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.data.repository.CustomerRepository
import com.invoice.contratista.data.source.local.relations.Customer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CreateCustomerViewModel @Inject constructor(private val customerRepository: CustomerRepository)
    : ViewModel() {
    fun createCustomer(customer: Customer) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                customerRepository.createCustomer(customer)
            }
        }
    }
}