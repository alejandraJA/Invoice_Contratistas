package com.invoice.contratista.ui.fragment.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invoice.contratista.domain.usecase.LoadDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loadDataUseCase: LoadDataUseCase
) : ViewModel() {
    fun login(function: (String) -> Unit) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                loadDataUseCase(function)
            }
        }
    }
}