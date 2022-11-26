package com.invoice.contratista.ui.activity.main

import androidx.lifecycle.ViewModel
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(utilsManager: UtilsManager) : ViewModel() {
    init {
        utilsManager.getIdPart()
    }
}