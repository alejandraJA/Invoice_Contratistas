package com.invoice.contratista.data.source.local.dao.product

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.invoice.contratista.data.source.local.entity.product.PriceEntity

@Dao
interface PriceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(priceEntity: PriceEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(prices: List<PriceEntity>)

    @Query("SELECT * FROM price WHERE product_id == :idProduct")
    fun findAllByIdProduct(idProduct: String): LiveData<List<PriceEntity>>

    @Query("SELECT * FROM price WHERE id == :id")
    fun findByIdPrice(id: String): LiveData<PriceEntity>

}