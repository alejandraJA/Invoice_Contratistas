package com.invoice.contratista.data.source.local.entity.product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey val id: String,
    val modified: String,
    val name: String,
    @ColumnInfo(name = "product_base_id")val idProductBase: String,
)