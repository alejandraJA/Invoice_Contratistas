package com.invoice.contratista.data.source.local.entity.product

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vendor")
data class VendorEntity(
    @PrimaryKey val id: String,
    val name: String,
    @ColumnInfo(name = "id_address")val idAddress: String,
)
