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

    @Query("insert into reserved (id, id_part, price_id, product_id) " +
            "values ( :idReserved " +
            "       , :idPart " +
            "       , (SELECT pri.unit_price " +
            "          FROM product pr " +
            "                   LEFT JOIN price pri on pr.id = pri.product_id " +
            "          ORDER BY pr.id " +
            "          LIMIT 1) " +
            "       , (SELECT pr.id " +
            "          FROM product pr " +
            "                   LEFT JOIN price pri on pr.id = pri.product_id " +
            "          ORDER BY pr.id " +
            "          LIMIT 1)) ")
    fun createDefault(idReserved: String, idPart: String)
}