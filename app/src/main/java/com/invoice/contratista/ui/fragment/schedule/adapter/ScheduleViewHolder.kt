package com.invoice.contratista.ui.fragment.schedule.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.data.source.local.entity.event.ScheduleEntity
import com.invoice.contratista.databinding.ItemScheduleBinding
import com.invoice.contratista.utils.Constants
import com.invoice.contratista.utils.DateUtils.getDate
import com.invoice.contratista.utils.DateUtils.getHour
import com.invoice.contratista.utils.StatesUtils.getStateSchedule

class ScheduleViewHolder(
    itemView: View,
    private val function: (ScheduleEntity) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemScheduleBinding.bind(itemView)

    fun bind(scheduleEntity: ScheduleEntity) {
        binding.schedule = scheduleEntity
        binding.textDate.text = scheduleEntity.date.getDate()
        binding.textHour.text = scheduleEntity.date.getHour()
        if (scheduleEntity.state.getStateSchedule() == Constants.StateSchedule.Pendiente)
            binding.imageState.visibility = View.GONE
        binding.cardEvent.setOnClickListener {
            function.invoke(scheduleEntity)
        }
    }
}