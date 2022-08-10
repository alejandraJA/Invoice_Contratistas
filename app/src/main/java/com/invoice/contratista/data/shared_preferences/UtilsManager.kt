package com.invoice.contratista.data.shared_preferences

import android.content.SharedPreferences
import com.invoice.contratista.utils.Constants
import javax.inject.Inject

class UtilsManager @Inject constructor(private val sharedPreferences: SharedPreferences) {
    private val editor = sharedPreferences.edit()

    fun setIdCustomer(idCustomer: String) = idCustomer.setString(Constants.ID_CUSTOMER)
    fun setIdBudget(idBudget: String) = idBudget.setString(Constants.ID_BUDGET)
    fun setIdPart(idPart: String) = idPart.setString(Constants.ID_PART)
    fun setIdEvent(idEvent: Long) = idEvent.setLong(Constants.ID_EVENT)
    fun setIdUser(idUser: String) = idUser.setString(Constants.ID_USER)
    fun setIdProduct(idProduct: String) = idProduct.setString(Constants.ID_PRODUCT)

    fun getIdCustomer() = Constants.ID_CUSTOMER.getString()
    fun getIdBudget() = Constants.ID_BUDGET.getString()
    fun getIdPart() = Constants.ID_PART.getString()
    fun getIdEvent() = Constants.ID_EVENT.getLong()
    fun getIdUser() = Constants.ID_USER.getString()
    fun getIdProduct() = Constants.ID_PRODUCT.getString()

    private fun Long.setLong(key: String) = editor.putLong(key, this).apply()
    private fun String.getLong() = sharedPreferences.getLong(this, 0)
    private fun String.setString(key: String) = editor.putString(key, this).apply()
    private fun String.getString() = sharedPreferences.getString(this, "")!!

}