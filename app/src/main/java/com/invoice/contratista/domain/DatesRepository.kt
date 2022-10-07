package com.invoice.contratista.domain

import com.invoice.contratista.data.local.dao.Dao
import com.invoice.contratista.data.local.entity.DateEntity
import com.invoice.contratista.data.shared_preferences.UtilsManager
import javax.inject.Inject

class DatesRepository @Inject constructor(
    private val dao: Dao,
    private val utilsManager: UtilsManager
) {
    /**
     * Metodo para obtener las fechas del historial de un evento
     * @return Lista de objetos de tipo [DateEntity]
     */
    fun getDates() = dao.getDates(utilsManager.getIdEvent())
}