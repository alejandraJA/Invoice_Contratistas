package com.invoice.contratista.ui.fragment.part.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.R

class TaxAdapter(private val listTax: MutableList<TaxItem>, private val function: (Double) -> Unit) :
    RecyclerView.Adapter<TaxViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TaxViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_tax, parent, false),
        function
    )

    override fun onBindViewHolder(holder: TaxViewHolder, position: Int) {
        holder.bind(listTax[position])
    }

    override fun getItemCount() = listTax.size

    @SuppressLint("NotifyDataSetChanged")
    fun setSubTotalPrice(subTotal: Double) {
        listTax.forEach {
            it.subtotal = subTotal
        }
        notifyDataSetChanged()
    }

}