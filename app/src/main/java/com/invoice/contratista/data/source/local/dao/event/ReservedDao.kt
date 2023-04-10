package com.invoice.contratista.data.source.local.dao.event

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.invoice.contratista.data.source.local.entity.event.ReservedEntity

@Dao
interface ReservedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(productEntity: ReservedEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(list: List<ReservedEntity>)

    @Query("DELETE FROM reserved")
    fun deleteAll()
}