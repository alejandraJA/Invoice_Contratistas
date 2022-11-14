package com.invoice.contratista.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.invoice.contratista.data.local.entity.event.ScheduleEntity

@Dao
interface ScheduleDao {

    @Query("SELECT DISTINCT * FROM schedule WHERE id_event == :idEvent ORDER BY date")
    fun getSchedules(idEvent: String): LiveData<List<ScheduleEntity>>

    @Query("SELECT DISTINCT * FROM schedule ORDER BY date")
    fun getSchedules(): LiveData<List<ScheduleEntity>>

    @Query(
        "INSERT INTO schedule " +
                "VALUES(:idSchedule, :idEvent, :date, :state, :note, :idAddress, " +
                "(SELECT legal_name " +
                "FROM customer " +
                "WHERE id == :idCustomer LIMIT 1))"
    )
    fun createSchedule(
        idSchedule: String,
        idEvent: String,
        date: String,
        state: String,
        note: String,
        idAddress: String,
        idCustomer: String
    )

    @Query("SELECT * FROM schedule WHERE id == :idSchedule")
    fun getSchedule(idSchedule: String): LiveData<ScheduleEntity>

    @Query("UPDATE schedule SET date =:date, note = :note WHERE id == :idSchedule")
    fun updateSchedule(date: String, note: String, idSchedule: String)

    @Query("UPDATE schedule SET state = 'Atendido' WHERE id == :idSchedule")
    fun updateStateSchedule(idSchedule: String)

}