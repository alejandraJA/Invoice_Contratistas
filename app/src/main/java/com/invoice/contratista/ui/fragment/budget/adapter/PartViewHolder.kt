package com.invoice.contratista.ui.fragment.budget.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.R
import com.invoice.contratista.data.local.relations.Part
import com.invoice.contratista.databinding.ItemPartBinding
import com.invoice.contratista.utils.MoneyUtils.moneyFormat

class PartViewHolder(itemView: View, private val function: (String, String) -> Unit) :
    RecyclerView.ViewHolder(itemView) {
    private val binding = ItemPartBinding.bind(itemView)

    @SuppressLint("SetTextI18n")
    fun bind(part: PartItem) {
        binding.apply {
            textPart.text = "${itemView.resources.getString(R.string.part)} ${part.partNumber}"
            textProductName.text = part.productName
            textQuantity.text = part.quantity.toString()
            textUnit.text = part.unitName
            textAmount.text = part.amount.moneyFormat()
            divider.visibility = View.VISIBLE
        }
        itemView.setOnClickListener {
            function.invoke(part.idPart, part.idProduct)
        }
    }

    fun lastPosition() {
        binding.divider.visibility = View.GONE
    }
}