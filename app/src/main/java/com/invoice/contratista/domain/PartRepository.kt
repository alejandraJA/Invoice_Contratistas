package com.invoice.contratista.domain

import androidx.lifecycle.LiveData
import com.invoice.contratista.data.local.dao.PartDao
import com.invoice.contratista.data.local.entity.event.PartEntity
import com.invoice.contratista.data.local.relations.Part
import com.invoice.contratista.data.shared_preferences.UtilsManager
import java.util.UUID
import javax.inject.Inject

class PartRepository @Inject constructor(
    private val dao: PartDao,
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

    fun createPart() =
        dao.createPart(UUID.randomUUID().toString(), utilsManager.getIdBudget())

    fun getNumber() = dao.getNumberOfPart(utilsManager.getIdBudget())
    fun updatePart(partEntity: PartEntity) = dao.setPart(partEntity)
    fun updateQuantity(quantity: Int) = dao.updateQuantity(quantity, utilsManager.getIdPart())
    fun updateDiscount(discount: Int) = dao.updateDiscount(discount, utilsManager.getIdPart())
    fun updateProduct(idProduct: String) = dao.updateProduct(idProduct, utilsManager.getIdPart())

    fun getPartsForRecycler() = dao.getPartsForRecycler(utilsManager.getIdBudget())

}