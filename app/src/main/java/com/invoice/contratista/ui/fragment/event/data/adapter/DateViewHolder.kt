package com.invoice.contratista.ui.fragment.event.data.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.data.local.entity.DateEntity
import com.invoice.contratista.databinding.ItemDateBinding
import com.invoice.contratista.utils.DateUtils.getDate
import com.invoice.contratista.utils.DateUtils.getHour

class DateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding = ItemDateBinding.bind(itemView)
    val divider = binding.materialDivider2
    fun bind(dateEntity: DateEntity) {
        binding.date = dateEntity

        binding.textDate.text = dateEntity.date.getDate()
        binding.textHour.text = dateEntity.date.getHour()
    }
}