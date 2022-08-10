package com.invoice.contratista.utils

import com.google.android.material.textfield.TextInputLayout

object Utils {
    private fun TextInputLayout.isNotEmptyUtils() = if (editText!!.text.toString().isNotEmpty()) {
        error = null
        true
    } else {
        error = "Campo requerido"
        false
    }

    fun TextInputLayout.getText() = if (isNotEmptyUtils()) editText!!.text.toString() else ""
}