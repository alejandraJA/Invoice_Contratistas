package com.invoice.contratista.ui.fragment.part.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.R
import com.invoice.contratista.databinding.ItemTaxBinding
import com.invoice.contratista.utils.MoneyUtils.moneyFormat

class TaxViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemTaxBinding.bind(itemView)
    private var rate = 0.00

    @SuppressLint("SetTextI18n")
    fun bind(taxItem: TaxItem) {
        rate = taxItem.rate
        binding.apply {
            textType.text = "${taxItem.type} (${
                String.format(
                    "%.0f",
                    (taxItem.rate * 100)
                )
            } %) ${if (taxItem.withholding) "-" else "+"} "
            textTax.text = taxItem.tax.moneyFormat()
            textTypeTax.visibility = if (taxItem.localTax) View.VISIBLE else View.INVISIBLE
            if (taxItem.factor == "Exento")
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    textType.setTextColor(itemView.resources.getColor(R.color.text_secondary, null))
                    textTypeTax.setTextColor(
                        itemView.resources.getColor(
                            R.color.text_secondary,
                            null
                        )
                    )
                    textTax.setTextColor(itemView.resources.getColor(R.color.text_secondary, null))
                } else {
                    textType.setTextColor(itemView.resources.getColor(R.color.text_secondary))
                    textTypeTax.setTextColor(itemView.resources.getColor(R.color.text_secondary))
                    textTax.setTextColor(itemView.resources.getColor(R.color.text_secondary))
                }
        }
    }
}