package com.invoice.contratista.domain

import androidx.lifecycle.LiveData
import com.invoice.contratista.data.local.dao.Dao
import com.invoice.contratista.data.local.relations.Part
import com.invoice.contratista.data.shared_preferences.UtilsManager
import javax.inject.Inject

class PartRepository @Inject constructor(
    private val dao: Dao,
    private val utilsManager: UtilsManager
) {

    /**
     * Metodo para obtener una partida en especifico de la base de datos Local
     * @return [LiveData] que contiene un objeto de tipo [Part]
     */
    fun getPart() = dao.getPart(utilsManager.getIdPart())

    /**
     * Metodo para obtener una lista de partidas relacionadas a una cotización de la base de datos local
     * @return [LiveData] de una lista de [Part]
     */
    fun getParts() = dao.getParts(utilsManager.getIdBudget())

}