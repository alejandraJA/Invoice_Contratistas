package com.invoice.contratista.data.source.local.entity.event

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "reserved", primaryKeys = ["id", "product_id", "id_part"])
data class ReservedEntity(
    val id: String,
    @ColumnInfo(name = "product_id") val idProduct: String,
    @ColumnInfo(name = "id_part") val idPart: String,
    @ColumnInfo(name = "price_id") val idReserved: String,
    val quantity: String? = "0",
    @ColumnInfo(name = "date_expiry" ) val dateExpiry: String? = "",
)