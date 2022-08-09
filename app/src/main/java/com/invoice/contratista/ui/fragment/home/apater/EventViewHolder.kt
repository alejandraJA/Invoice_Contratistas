package com.invoice.contratista.ui.fragment.home.apater

import android.annotation.SuppressLint
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.R
import com.invoice.contratista.utils.Constants
import com.invoice.contratista.databinding.ItemScheduleBinding

class EventViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemScheduleBinding.bind(view)

    @SuppressLint("UseCompatLoadingForDrawables")
    fun bind() {
        binding.cardEvent.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_home_to_eventFragment)
        }
    }
}