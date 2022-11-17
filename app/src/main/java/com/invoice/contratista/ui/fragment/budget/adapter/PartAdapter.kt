package com.invoice.contratista.ui.fragment.budget.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.R
import com.invoice.contratista.data.local.relations.Part

class PartAdapter(private val list: List<Part>, private val function: (String, String) -> Unit) :
    RecyclerView.Adapter<PartViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PartViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_part, parent, false),
        function
    )

    override fun onBindViewHolder(holder: PartViewHolder, position: Int) {
        holder.bind(list[position])
        if (position == (list.size - 1)) holder.lastPosition()
    }

    override fun getItemCount() = list.size
}