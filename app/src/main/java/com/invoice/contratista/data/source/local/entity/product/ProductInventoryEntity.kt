package com.invoice.contratista.data.source.local.entity.product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_inventory")
data class ProductInventoryEntity(
    @PrimaryKey val id: String,
    val modified: String,
    val quantity: Int,
    @ColumnInfo(name = "product_id") val idProduct: String,
)