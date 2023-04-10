package com.invoice.contratista.data.source.local.dao.product

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.invoice.contratista.data.source.local.entity.product.CostEntity

@Dao
interface CostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(costEntity: CostEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(listCosts: List<CostEntity>)

    @Query("SELECT * FROM cost WHERE product_inventory_id == :idProductInventory")
    fun findByIdProductInventory(idProductInventory: String): LiveData<List<CostEntity>>

    @Query("SELECT * FROM cost WHERE id = :idCost")
    fun findByIdCost(idCost: String): LiveData<CostEntity>

    @Query("DELETE FROM cost")
    fun deleteAll()
}