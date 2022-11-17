package com.invoice.contratista.domain

import com.invoice.contratista.data.local.dao.TaxDao
import com.invoice.contratista.data.shared_preferences.UtilsManager
import javax.inject.Inject

class TaxRepository @Inject constructor(
    private val taxDao: TaxDao,
    private val utilsManager: UtilsManager
) {
    fun getParts() = taxDao.getParts(
        utilsManager.getIdProduct(),
        utilsManager.getIdPart()
    )
}