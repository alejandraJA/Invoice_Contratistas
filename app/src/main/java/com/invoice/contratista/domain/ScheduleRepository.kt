package com.invoice.contratista.domain

import com.invoice.contratista.data.local.dao.Dao
import com.invoice.contratista.data.local.entity.AddressEntity
import com.invoice.contratista.data.shared_preferences.UtilsManager
import com.invoice.contratista.utils.Constants
import java.util.*
import javax.inject.Inject

class ScheduleRepository @Inject constructor(
    private val dao: Dao,
    private val utilsManager: UtilsManager
) {
    fun getSchedulesByEvent() = dao.getSchedules(utilsManager.getIdEvent())
    fun insertSchedule(date: String, note: String, address: AddressEntity) {
        val idSchedule = UUID.randomUUID().toString()
        address.idCustomer = idSchedule
        if (utilsManager.getAction()) {
            dao.setAddress(address)
            dao.createSchedule(
                idSchedule = idSchedule,
                idEvent = utilsManager.getIdEvent(),
                date = date,
                state = Constants.StateSchedule.Pendiente.name,
                note = note,
                idAddress = address.id,
                idCustomer = utilsManager.getIdCustomer()
            )
        } else {
            dao.updateAddress(
                address.street,
                address.exterior,
                address.interior,
                address.neighborhood,
                address.city,
                address.municipality,
                address.zip,
                address.state,
                utilsManager.getIdSchedule()
            )
            dao.updateSchedule(date, note, utilsManager.getIdSchedule())
        }
    }
    fun getSchedules() = dao.getSchedules()
    fun getSchedule() = dao.getSchedule(utilsManager.getIdSchedule())
    fun getAddressOfSchedule() = dao.getAddressOfSchedule(utilsManager.getIdSchedule())
    fun updateStateSchedule() = dao.updateStateSchedule(utilsManager.getIdSchedule())
}