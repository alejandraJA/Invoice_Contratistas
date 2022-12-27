package com.invoice.contratista.data.source.local.entity.product

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "inventory", primaryKeys = ["id", "id_product", "id_category"])
data class InventoryEntity(
    val id: String,
    @ColumnInfo(name = "id_product") val idProduct: String,
    @ColumnInfo(name = "id_category") val idCategory: String,
    val available: String,
)