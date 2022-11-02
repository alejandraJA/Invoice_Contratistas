package com.invoice.contratista.utils

object MoneyUtils {
    fun Double.moneyFormat() = String.format("%.2f", this)
}