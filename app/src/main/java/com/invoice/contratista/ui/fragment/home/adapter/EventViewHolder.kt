package com.invoice.contratista.ui.fragment.home.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.R
import com.invoice.contratista.data.local.entity.EventEntity
import com.invoice.contratista.databinding.ItemEventBinding

class EventViewHolder(private val view: View, private val function: (EventEntity) -> Unit) : RecyclerView.ViewHolder(view) {
    private val binding = ItemEventBinding.bind(view)

    @SuppressLint("UseCompatLoadingForDrawables")
    fun bind(eventEntity: EventEntity) {
        binding.event = eventEntity
        binding.cardEvent.setOnClickListener {
            function.invoke(eventEntity)
            view.findNavController().navigate(R.id.action_navigation_home_to_eventFragment)
        }
    }
}