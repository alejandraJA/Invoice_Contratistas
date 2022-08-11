package com.invoice.contratista.utils

import com.google.android.material.textfield.TextInputLayout
import com.invoice.contratista.utils.Utils.getDate
import com.invoice.contratista.utils.Utils.setText
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun TextInputLayout.isNotEmptyUtils() = if (editText!!.text.toString().isNotEmpty()) {
        error = null
        true
    } else {
        error = "Campo requerido"
        false
    }

    fun TextInputLayout.setText(string: String) {
        editText!!.setText("")
        editText!!.append(string)
    }

    fun TextInputLayout.getText() = if (isNotEmptyUtils()) editText!!.text.toString() else ""

    fun String.getDate(): String {
        val date =  SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this)
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        return formatter.format(date!!)
    }

    fun String.getHour(): String {
        val date =  SimpleDateFormat("yyyy-MM-dd HH:mm").parse(this)
        val formatter = SimpleDateFormat("HH:mm")
        return formatter.format(date!!)
    }

    fun Date.getDateComplete(): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
        return formatter.format(this)
    }
}