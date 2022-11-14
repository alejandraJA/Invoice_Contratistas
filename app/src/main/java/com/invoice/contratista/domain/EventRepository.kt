package com.invoice.contratista.domain

import com.invoice.contratista.data.local.dao.DateDao
import com.invoice.contratista.data.local.dao.EventDao
import com.invoice.contratista.data.local.entity.DateEntity
import com.invoice.contratista.data.local.entity.EventEntity
import com.invoice.contratista.data.local.relations.Event
import com.invoice.contratista.data.shared_preferences.UtilsManager
import com.invoice.contratista.utils.Constants
import com.invoice.contratista.utils.DateUtils.getDateComplete
import java.util.*
import javax.inject.Inject

class EventRepository @Inject constructor(
    private val eventDao: EventDao,
    private val dateDao: DateDao,
    private val utilsManager: UtilsManager
) {

    /**
     * Metodo para crear un evento
     * @param event Objeto de tipo [EventEntity]
     */
    fun createEvent(event: EventEntity) {
        eventDao.setEvent(event)
        dateDao.setDate(
            DateEntity(
                id = 0,
                idReference = event.id,
                date = Date().getDateComplete(),
                name = Constants.StateEvent.Creado.name
            )
        )
        utilsManager.setIdEvent(event.id)
        utilsManager.setIdCustomer(event.id_customer)
    }

    /**
     * Metodo para obtener todos los eventos activos
     * @return Lista de objetos de tipo [EventEntity]
     */
    fun getEvents() = eventDao.getEvents()

    /**
     * Metodo para obtener un evento especifico
     * @return Lista de objetos de tipo [Event]
     */
    fun getEvent() = eventDao.getEvent(utilsManager.getIdEvent())

    /**
     * Metodo para actualizar la nota del evento
     * @param note Objeto de tipo [String]
     */
    fun updateNoteEvent(note: String) = eventDao.updateNoteEvent(utilsManager.getIdEvent(), note)

}