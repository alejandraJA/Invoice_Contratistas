package com.invoice.contratista.data.source.local.entity.product

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "reserved", primaryKeys = ["id", "id_product", "id_part"])
data class ReservedEntity(
    val id: String,
    @ColumnInfo(name = "id_product") val idProduct: String,
    @ColumnInfo(name = "id_part") val idPart: String,
    val dateExpiry: String,
    val quantity: String,
)