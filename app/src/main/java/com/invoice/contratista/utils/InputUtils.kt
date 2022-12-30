package com.invoice.contratista.utils

import com.google.android.material.textfield.TextInputLayout
import com.invoice.contratista.R

object InputUtils {
    private fun TextInputLayout.isNotEmptyUtils() = if (editText!!.text.toString().isNotEmpty()) {
        error = null
        true
    } else {
        error = "${editText!!.hint} ${context.getString(R.string.required)}."
        false
    }

    fun TextInputLayout.setText(string: String) {
        editText!!.setText("")
        editText!!.append(string)
    }

    fun TextInputLayout.getText() = editText!!.text.toString().ifEmpty { "" }

    fun TextInputLayout.getTextWithValidation() =
        if (isNotEmptyUtils()) editText!!.text.toString() else ""

}