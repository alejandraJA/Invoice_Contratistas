package com.invoice.contratista.ui.fragment.budget.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.R
import com.invoice.contratista.data.local.relations.Part
import com.invoice.contratista.databinding.ItemPartBinding
import com.invoice.contratista.utils.MoneyUtils.moneyFormat

class PartViewHolder(itemView: View, private val function: (String) -> Unit) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemPartBinding.bind(itemView)

    @SuppressLint("SetTextI18n")
    fun bind(part: Part) {
        binding.apply {
            textProduct.text = part.product!!.product!!.description
            textQuantity.text = part.partEntity!!.quantity.toString()
            textPrice.text = part.product.product!!.price.moneyFormat()
            textTotal.text = (part.product.product.price * part.partEntity.quantity).moneyFormat()
            textPartNumber.text =
                "${itemView.resources.getString(R.string.part)} ${part.partEntity.number}"
            divider.visibility = View.VISIBLE
        }
        itemView.setOnClickListener {
            function.invoke(part.partEntity!!.id)
        }
    }

    fun lastPosition() {
        binding.divider.visibility = View.GONE
    }
}