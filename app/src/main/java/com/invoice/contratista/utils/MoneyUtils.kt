package com.invoice.contratista.utils

import java.text.DecimalFormat
import java.text.NumberFormat

object MoneyUtils {
    fun Double.moneyFormat(): String {
        val format: NumberFormat = DecimalFormat("###,###.##")
        return format.format(this)
    }
}