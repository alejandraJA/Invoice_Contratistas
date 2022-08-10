package com.invoice.contratista.ui.fragment.event.create

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.data.local.entity.CustomerEntity
import com.invoice.contratista.data.local.entity.EventEntity
import com.invoice.contratista.domain.DataRepository
import com.invoice.contratista.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CreateEventViewModel @Inject constructor(
    private val dataRepository: DataRepository
) : ViewModel() {
    fun createEvent(idCustomer: String, note: String, eventName: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                dataRepository.createEvent(
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
        addSource(dataRepository.getCustomers()) {
            if (it.isNotEmpty()) value = it
        }
    }
}