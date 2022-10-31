package com.invoice.contratista.ui.fragment.budgets.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.R
import com.invoice.contratista.data.local.entity.event.BudgetEntity
import com.invoice.contratista.databinding.ItemBudgetBinding

class BudgetViewHolder(view: View, private val onClick: (Long) -> Unit) : RecyclerView.ViewHolder(view) {
    private val binding = ItemBudgetBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun bind(budgetEntity: BudgetEntity) {
        binding.textTitleBudget.text =
            "${itemView.resources.getString(R.string.budget)}_${budgetEntity.number}"
        binding.idTextBudget.text = budgetEntity.number.toString()
        binding.textDate.text = budgetEntity.date
        binding.textStatus.text = budgetEntity.status
        binding.itemBudget.setOnClickListener {
            onClick.invoke(budgetEntity.id)
        }
    }
}