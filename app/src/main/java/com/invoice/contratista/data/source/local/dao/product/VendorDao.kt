package com.invoice.contratista.data.source.local.dao.product

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.invoice.contratista.data.source.local.entity.product.VendorEntity

@Dao
interface VendorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(productEntity: VendorEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(list: List<VendorEntity>)

    @Query("DELETE FROM vendor")
    fun deleteAll()
}