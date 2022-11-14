package com.invoice.contratista.domain

import com.invoice.contratista.data.local.dao.AddressDao
import com.invoice.contratista.data.local.dao.ScheduleDao
import com.invoice.contratista.data.local.entity.AddressEntity
import com.invoice.contratista.data.shared_preferences.UtilsManager
import com.invoice.contratista.utils.Constants
import java.util.*
import javax.inject.Inject

class ScheduleRepository @Inject constructor(
    private val scheduleDao: ScheduleDao,
    private val addressDao: AddressDao,
    private val utilsManager: UtilsManager
) {
    fun getSchedulesByEvent() = scheduleDao.getSchedules(utilsManager.getIdEvent())
    fun insertSchedule(date: String, note: String, address: AddressEntity) {
        val idSchedule = UUID.randomUUID().toString()
        address.idCustomer = idSchedule
        if (utilsManager.getAction()) {
            addressDao.setAddress(address)
            scheduleDao.createSchedule(
                idSchedule = idSchedule,
                idEvent = utilsManager.getIdEvent(),
                date = date,
                state = Constants.StateSchedule.Pendiente.name,
                note = note,
                idAddress = address.id,
                idCustomer = utilsManager.getIdCustomer()
            )
        } else {
            addressDao.updateAddress(
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
            scheduleDao.updateSchedule(date, note, utilsManager.getIdSchedule())
        }
    }

    fun getSchedules() = scheduleDao.getSchedules()
    fun getSchedule() = scheduleDao.getSchedule(utilsManager.getIdSchedule())
    fun getAddressOfSchedule() = addressDao.getAddress(utilsManager.getIdSchedule())
    fun updateStateSchedule() = scheduleDao.updateStateSchedule(utilsManager.getIdSchedule())
}