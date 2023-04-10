package com.invoice.contratista.data.source.local.entity.product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cost")
data class CostEntity(
    @PrimaryKey val id: String,
    val date: String,
    val quantity: Int,
    @ColumnInfo(name = "unit_cost") val unitCost: Double,
    @ColumnInfo(name = "id_vendor") val idVendor: String,
    @ColumnInfo(name = "product_inventory_id") val idProductInventory: String,
)
