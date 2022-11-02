package com.invoice.contratista.ui.fragment.budget.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.data.local.relations.Part
import com.invoice.contratista.databinding.ItemPartBinding
import com.invoice.contratista.utils.MoneyUtils.moneyFormat

class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemPartBinding.bind(itemView)
    fun bind(part: Part) {
        binding.textProduct.text = part.product!!.product!!.description
        binding.textQuantity.text = part.partEntity!!.quantity.toString()
        binding.textPrice.text = part.product.product!!.price.moneyFormat()
        binding.textTotal.text = (part.product.product.price * part.partEntity.quantity).moneyFormat()
        binding.divider.visibility = View.VISIBLE
    }

    fun lastPosition() {
        binding.divider.visibility = View.GONE
    }
}