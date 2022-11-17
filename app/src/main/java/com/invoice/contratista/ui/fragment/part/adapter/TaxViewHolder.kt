package com.invoice.contratista.ui.fragment.part.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.databinding.ItemTaxBinding
import com.invoice.contratista.utils.MoneyUtils.moneyFormat

class TaxViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemTaxBinding.bind(itemView)
    private var rate = 0.00

    @SuppressLint("SetTextI18n")
    fun bind(taxItem: TaxItem) {
        rate = taxItem.rate
        binding.apply {
            textType.text = "${taxItem.type} (${String.format("%.0f", (taxItem.rate * 100))} %)"
            textTax.text = taxItem.tax.moneyFormat()
            textTypeTax.visibility = if (taxItem.localTax) View.VISIBLE else View.INVISIBLE
        }
    }
}