package com.invoice.contratista.ui.fragment.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.domain.FacturapiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val facturapiRepository: FacturapiRepository
) : ViewModel() {
    fun login(error: (String) -> Unit) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                facturapiRepository.loadData(error)
            }
        }
    }
}