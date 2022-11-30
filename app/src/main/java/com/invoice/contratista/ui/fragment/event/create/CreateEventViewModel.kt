package com.invoice.contratista.ui.fragment.event.create

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.data.repository.CustomerRepository
import com.invoice.contratista.data.repository.EventRepository
import com.invoice.contratista.data.source.local.entity.CustomerEntity
import com.invoice.contratista.data.source.local.entity.EventEntity
import com.invoice.contratista.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CreateEventViewModel @Inject constructor(
    private val eventRepository: EventRepository,
    private val customerRepository: CustomerRepository
) : ViewModel() {
    fun createEvent(idCustomer: String, note: String, eventName: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                eventRepository.createEvent(
                    EventEntity(
                        UUID.randomUUID().toString(),
                        idCustomer,
                        Constants.StateEvent.Creado.toString(),
                        note,
                        eventName
                    )
                )
            }
        }
    }

    val customer = MediatorLiveData<List<CustomerEntity>>().apply {
        addSource(customerRepository.getCustomers()) {
            if (it.isNotEmpty()) value = it
        }
    }
}