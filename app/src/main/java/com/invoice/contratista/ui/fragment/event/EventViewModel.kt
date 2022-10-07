package com.invoice.contratista.ui.fragment.event

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.invoice.contratista.data.local.entity.CustomerEntity
import com.invoice.contratista.domain.CustomerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(private val customerRepository: CustomerRepository): ViewModel() {
    val customer = MediatorLiveData<CustomerEntity>().apply {
        addSource(customerRepository.getCustomerEntity()) {
            if (it != null) value = it
        }
    }
}