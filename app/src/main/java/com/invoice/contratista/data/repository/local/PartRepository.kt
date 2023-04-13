package com.invoice.contratista.data.repository.local

import androidx.lifecycle.LiveData
import com.invoice.contratista.data.source.local.dao.event.PartDao
import com.invoice.contratista.data.source.local.dao.event.ReservedDao
import com.invoice.contratista.data.source.local.entity.event.PartEntity
import com.invoice.contratista.data.source.local.relations.Part
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
import java.util.*
import javax.inject.Inject

class PartRepository @Inject constructor(
    private val dao: PartDao,
    private val daoReservedDao: ReservedDao,
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
    fun getParts() = dao.getParts(utilsManager.idBudget)

    fun createPart() {
        val idPart = UUID.randomUUID().toString()
        val idReserved = UUID.randomUUID().toString()
        daoReservedDao.createDefault(idReserved = idReserved, idPart = idPart)
        dao.createPart(idPart = idPart, idBudget = utilsManager.idBudget, idReserved = idReserved)
    }

    fun getNumber() = dao.getNumberOfPart(utilsManager.idBudget)
    fun updatePart(partEntity: PartEntity) = dao.setPart(partEntity)
    fun updateQuantity(quantity: Int) = dao.updateQuantity(quantity, utilsManager.getIdPart())
    fun updateDiscount(discount: Int) = dao.updateDiscount(discount, utilsManager.getIdPart())
    fun updateProduct(idProduct: String) = dao.updateProduct(idProduct, utilsManager.idReserved)

    fun getPartsForRecycler() = dao.getPartsForRecycler(utilsManager.idBudget)

}