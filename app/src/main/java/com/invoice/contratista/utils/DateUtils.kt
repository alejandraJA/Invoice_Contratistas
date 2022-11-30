package com.invoice.contratista.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
object DateUtils {

    fun String.getDate(): String {
        val date = SimpleDateFormat("dd-MM-yyyy HH:mm").parse(this)
        val formatter = SimpleDateFormat("dd-MM-yyyy")
        return formatter.format(date!!)
    }

    fun String.getHour(): String {
        val date = SimpleDateFormat("dd-MM-yyyy HH:mm").parse(this)
        val formatter = SimpleDateFormat("HH:mm")
        return formatter.format(date!!)
    }

    fun Date.getDateComplete(): String {
        val formatter = SimpleDateFormat("dd-MM-yyyy HH:mm")
        return formatter.format(this)
    }

    fun Date.getDateWithoutHour(): String {
        val formatter = SimpleDateFormat("dd-MM-yyyy")
        return formatter.format(this)
    }

}