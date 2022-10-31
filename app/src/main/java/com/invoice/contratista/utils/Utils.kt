package com.invoice.contratista.utils

import android.annotation.SuppressLint
import android.content.res.Resources
import com.google.android.material.textfield.TextInputLayout
import com.invoice.contratista.R
import com.invoice.contratista.data.local.entity.AddressEntity
import com.invoice.contratista.databinding.LayoutAddressBinding
import com.invoice.contratista.utils.Utils.getDateComplete
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
object Utils {
    private fun TextInputLayout.isNotEmptyUtils() = if (editText!!.text.toString().isNotEmpty()) {
        error = null
        true
    } else {
        error = context.getString(R.string.required)
        false
    }

    fun TextInputLayout.setText(string: String) {
        editText!!.setText("")
        editText!!.append(string)
    }

    fun TextInputLayout.getText() = editText!!.text.toString().ifEmpty { "" }

    fun TextInputLayout.getTextWithValidation() =
        if (isNotEmptyUtils()) editText!!.text.toString() else ""

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

    fun LayoutAddressBinding.getAddressObject() = AddressEntity(
        id = UUID.randomUUID().toString(),
        street = layoutStreet.getTextWithValidation(),
        exterior = layoutExterior.getTextWithValidation(),
        interior = layoutInterior.getTextWithValidation(),
        neighborhood = layoutNeighborhood.getTextWithValidation(),
        city = layoutCity.getTextWithValidation(),
        municipality = layoutMunicipality.getTextWithValidation(),
        zip = layoutZip.getTextWithValidation(),
        state = layoutState.getTextWithValidation(),
        country = layoutCountry.getTextWithValidation(),
        idCustomer = "",
    )

    fun AddressEntity.isNotEmpty() =
        street.isNotEmpty()
                && exterior.isNotEmpty()
                && neighborhood.isNotEmpty()
                && city.isNotEmpty()
                && municipality.isNotEmpty()
                && zip.isNotEmpty()
                && state.isNotEmpty()

    fun AddressEntity.getAddress(resources: Resources) = "$street, " +
            "${
                if (interior.isEmpty())
                    "${resources.getString(R.string.exterior)} $exterior"
                else "${resources.getString(R.string.interior)} $interior, " +
                        "${resources.getString(R.string.exterior)} $exterior"
            }, " +
            "$zip, $neighborhood, " +
            "$city, ${municipality}, " +
            "$state, $country"

    fun String.getStatusBudget() = when (this) {
        Constants.BudgetStatus.Pendiente.name -> Constants.BudgetStatus.Pendiente
        Constants.BudgetStatus.Espera.name -> Constants.BudgetStatus.Espera
        Constants.BudgetStatus.Cancelado.name -> Constants.BudgetStatus.Cancelado
        Constants.BudgetStatus.Autorizado.name -> Constants.BudgetStatus.Autorizado
        else -> Constants.BudgetStatus.Pendiente
    }

    fun String.getStateSchedule() = when (this) {
        Constants.StateSchedule.Pendiente.name -> Constants.StateSchedule.Pendiente
        Constants.StateSchedule.Atendido.name -> Constants.StateSchedule.Atendido
        else -> Constants.StateSchedule.Pendiente
    }

}