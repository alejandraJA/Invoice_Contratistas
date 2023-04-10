package com.invoice.contratista.data.source.local.entity.product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "price")
data class PriceEntity(
    @PrimaryKey val id: String,
    val date: String,
    @ColumnInfo(name = "unit_price")val unitPrice: Double,
    @ColumnInfo(name = "product_id") val idProduct: String,
)