package com.invoice.contratista.ui.fragment.event.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.R
import com.invoice.contratista.data.local.entity.DateEntity

class DateAdapter(private val list: List<DateEntity>) : RecyclerView.Adapter<DateViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DateViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_date, parent, false),
    )

    override fun onBindViewHolder(holder: DateViewHolder, position: Int){
        holder.bind(list[position])
        if (position == list.lastIndex) holder.divider.visibility = View.GONE
    }

    override fun getItemCount() = list.size
}