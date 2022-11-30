package com.invoice.contratista.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "date")
data class DateEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val idReference: String,
    val date: String,
    val name: String,
)