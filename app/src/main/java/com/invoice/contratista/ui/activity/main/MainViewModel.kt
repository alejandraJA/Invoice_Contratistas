package com.invoice.contratista.ui.activity.main

import androidx.lifecycle.ViewModel
import com.invoice.contratista.data.shared_preferences.UtilsManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val utilsManager: UtilsManager)
    : ViewModel() {
}