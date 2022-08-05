package com.invoice.contratista.ui.fragment.home.apater

import android.annotation.SuppressLint
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.R
import com.invoice.contratista.utils.Constants
import com.invoice.contratista.databinding.ToDoBinding

class EventViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ToDoBinding.bind(view)

    @SuppressLint("UseCompatLoadingForDrawables")
    fun bind(event: Event) {
        binding.event = event
        binding.cardEvent.setOnClickListener {
            view.findNavController().navigate(R.id.action_navigation_home_to_eventFragment)
            when (event.priority) {
                Constants.Priority.Urgent -> binding.imagePriority.setImageDrawable(
                    view.resources.getDrawable(
                        R.drawable.ic_bell, view.resources.newTheme()
                    )
                )
                Constants.Priority.Important -> binding.imagePriority.setImageDrawable(
                    view.resources.getDrawable(
                        R.drawable.ic_exclamation, view.resources.newTheme()
                    )
                )
                Constants.Priority.Medium -> binding.imagePriority.setImageDrawable(
                    view.resources.getDrawable(
                        R.drawable.ic_dot, view.resources.newTheme()
                    )
                )
                Constants.Priority.Low -> binding.imagePriority.setImageDrawable(
                    view.resources.getDrawable(
                        R.drawable.ic_arrow_down, view.resources.newTheme()
                    )
                )
            }
        }
    }
}