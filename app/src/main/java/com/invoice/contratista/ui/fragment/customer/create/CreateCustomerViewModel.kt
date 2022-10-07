package com.invoice.contratista.ui.fragment.customer.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.data.local.relations.Customer
import com.invoice.contratista.domain.CustomerRepository
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