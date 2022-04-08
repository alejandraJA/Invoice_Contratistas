package com.invoice.contratista.ui.fragment.home.apater

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.R
import com.invoice.contratista.config.GlobalVariables
import com.invoice.contratista.databinding.ToDoBinding
import com.invoice.contratista.ui.activity.event.EventActivity

class EventViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ToDoBinding.bind(view)

    @SuppressLint("UseCompatLoadingForDrawables")
    fun bind(event: Event) {
        binding.event = event
        binding.cardEvent.setOnClickListener {
            view.context.startActivity(Intent(view.context, EventActivity::class.java))
            when (event.priority) {
                GlobalVariables.Priority.Urgent -> binding.imagePriority.setImageDrawable(
                    view.resources.getDrawable(
                        R.drawable.ic_bell, view.resources.newTheme()
                    )
                )
                GlobalVariables.Priority.Important -> binding.imagePriority.setImageDrawable(
                    view.resources.getDrawable(
                        R.drawable.ic_exclamation, view.resources.newTheme()
                    )
                )
                GlobalVariables.Priority.Medium -> binding.imagePriority.setImageDrawable(
                    view.resources.getDrawable(
                        R.drawable.ic_dot, view.resources.newTheme()
                    )
                )
                GlobalVariables.Priority.Low -> binding.imagePriority.setImageDrawable(
                    view.resources.getDrawable(
                        R.drawable.ic_arrow_down, view.resources.newTheme()
                    )
                )
            }
        }
    }
}