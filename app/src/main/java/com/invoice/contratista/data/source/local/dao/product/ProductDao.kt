package com.invoice.contratista.data.source.local.dao.product

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.invoice.contratista.data.source.local.entity.product.ProductEntity

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(productEntity: ProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(list: List<ProductEntity>)

    @Query("DELETE FROM product_inventory")
    fun deleteAll()

}