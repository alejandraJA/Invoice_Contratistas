package com.invoice.contratista.data.repository.local

import com.invoice.contratista.data.source.local.dao.DateDao
import com.invoice.contratista.data.source.local.entity.DateEntity
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
import javax.inject.Inject

class DatesRepository @Inject constructor(
    private val dao: DateDao,
    private val utilsManager: UtilsManager
) {
    /**
     * Metodo para obtener las fechas del historial de un evento
     * @return Lista de objetos de tipo [DateEntity]
     */
    fun getDates() = dao.getDates(utilsManager.getIdEvent())
}