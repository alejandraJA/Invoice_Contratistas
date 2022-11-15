package com.invoice.contratista.data.shared_preferences

import android.content.Context
import com.invoice.contratista.utils.Constants
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class UtilsManager @Inject constructor(@ApplicationContext context: Context) {
    private val sharedPreferences = context.getSharedPreferences("utils", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    fun setIdCustomer(idCustomer: String) = idCustomer.setString(Constants.ID_CUSTOMER)
    fun setIdBudget(idBudget: String) = idBudget.setString(Constants.ID_BUDGET)
    fun setIdPart(idPart: String) = idPart.setString(Constants.ID_PART)
    fun setIdEvent(idEvent: String) = idEvent.setString(Constants.ID_EVENT)
    fun setIdProduct(idProduct: String) = idProduct.setString(Constants.ID_PRODUCT)
    fun setIdNote(idNote: String) = idNote.setString(Constants.ID_NOTE)
    fun setIdSchedule(idSchedule: String) = idSchedule.setString(Constants.ID_SCHEDULE)
    fun setAction(action: Boolean) = action.setBoolean("Action")

    fun getIdCustomer() = Constants.ID_CUSTOMER.getString()
    fun getIdBudget() = Constants.ID_BUDGET.getString()
    fun getIdPart() = Constants.ID_PART.getString()
    fun getIdEvent() = Constants.ID_EVENT.getString()
    fun getIdProduct() = Constants.ID_PRODUCT.getString()
    fun getIdNote() = Constants.ID_NOTE.getString()
    fun getIdSchedule() = Constants.ID_SCHEDULE.getString()
    fun getAction() = "Action".getBoolean()

    private fun String.setString(key: String) = editor.putString(key, this).apply()
    private fun String.getString() = sharedPreferences.getString(this, "")!!
    private fun Boolean.setBoolean(key: String) = editor.putBoolean(key, this).apply()
    private fun String.getBoolean() = sharedPreferences.getBoolean(this, false)

}