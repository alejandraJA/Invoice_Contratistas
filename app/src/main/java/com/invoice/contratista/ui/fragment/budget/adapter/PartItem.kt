package com.invoice.contratista.ui.fragment.budget.adapter

import androidx.room.ColumnInfo

data class PartItem(
    @ColumnInfo(name = "id_part") val idPart: String,
    @ColumnInfo(name = "product_name") val productName: String,
    val amount: Double,
    val quantity: Int,
    @ColumnInfo(name = "part_number") val partNumber: Int,
    @ColumnInfo(name = "unit_name") val unitName: String,
    @ColumnInfo(name = "id_product") val idProduct: String,
)