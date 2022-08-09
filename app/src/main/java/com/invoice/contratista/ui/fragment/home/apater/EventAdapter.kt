package com.invoice.contratista.ui.fragment.home.apater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.R

class EventAdapter(private val list: List<Event>): RecyclerView.Adapter<EventViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EventViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false)
    )

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = list.size
}