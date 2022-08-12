package com.invoice.contratista.ui.fragment.schedule.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.R
import com.invoice.contratista.data.local.entity.event.ScheduleEntity

class ScheduleAdapter(
    private val list: List<ScheduleEntity>,
    private val function: (ScheduleEntity) -> Unit
) : RecyclerView.Adapter<ScheduleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ScheduleViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false),
        function
    )

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount() = list.size
}