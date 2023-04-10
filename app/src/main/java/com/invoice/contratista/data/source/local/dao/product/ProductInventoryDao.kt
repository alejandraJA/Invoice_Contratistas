package com.invoice.contratista.data.source.local.dao.product

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.invoice.contratista.data.source.local.entity.product.ProductInventoryEntity

@Dao
interface ProductInventoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(productEntity: ProductInventoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(list: List<ProductInventoryEntity>)

    @Query("DELETE FROM product")
    fun deleteAll()
}