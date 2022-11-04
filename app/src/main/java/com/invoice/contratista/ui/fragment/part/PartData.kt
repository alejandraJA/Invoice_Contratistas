package com.invoice.contratista.ui.fragment.part

import com.invoice.contratista.ui.fragment.part.adapter.TaxAdapter
import com.invoice.contratista.utils.MoneyUtils.moneyFormat

class PartData {

    enum class Operator { Sum, Res }

    private var price = 0.00
    private var taxes = 0.00
    private var gain = 0.00
    var subTotal = 0.00
    var partNumber = 0
    var discount = 0.00
    var quantity = 1

    fun getTotal(tax: Double): String {
        taxes = +tax
        return (subTotal + taxes).moneyFormat()
    }

    fun changeQuatity(
        operator: Operator,
        taxAdapter: TaxAdapter,
        function: (String, String, String) -> Unit
    ) {
        if (operator == Operator.Res && quantity != 0) quantity--
        if (operator == Operator.Sum) quantity++
        getTotals(taxAdapter, function)
    }

    fun getTotals(
        taxAdapter: TaxAdapter,
        function: (String, String, String) -> Unit
    ) {
        taxes = 0.00
        subTotal = (quantity * price) - discount
        taxAdapter.setSubTotalPrice(subTotal)
        function.invoke(
            subTotal.moneyFormat(),
            quantity.toString(),
            (gain * quantity).moneyFormat()
        )
    }

    fun getPrices(
        price: Double,
        gain: Int,
        taxAdapter: TaxAdapter,
        function: (String, String, String, String, String, String) -> Unit
    ) {
        this.price = price
        this.gain = ((gain * price) / 100)
        getTotals(taxAdapter) { subTotal, quantity, totalGain ->
            function.invoke(
                this.price.moneyFormat(),
                this.gain.moneyFormat(),
                this.discount.moneyFormat(),
                subTotal,
                quantity,
                totalGain
            )
        }
    }
}