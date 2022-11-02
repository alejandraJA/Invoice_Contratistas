package com.invoice.contratista.ui.fragment.budgets.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.R
import com.invoice.contratista.data.local.entity.event.BudgetEntity
import com.invoice.contratista.databinding.ItemBudgetBinding
import com.invoice.contratista.utils.Constants
import com.invoice.contratista.utils.Utils.getStatusBudget

class BudgetViewHolder(view: View, private val onClick: (String) -> Unit) :
    RecyclerView.ViewHolder(view) {
    private val binding = ItemBudgetBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun bind(budgetEntity: BudgetEntity) {
        binding.apply {
            val color = when (budgetEntity.status.getStatusBudget()) {
                Constants.BudgetStatus.Pendiente -> R.color.warning
                Constants.BudgetStatus.Espera -> R.color.warning
                Constants.BudgetStatus.Cancelado -> R.color.errorCards
                Constants.BudgetStatus.Autorizado -> R.color.success
            }
            textTitleBudget.text =
                "${itemView.resources.getString(R.string.budget)}_${budgetEntity.number}"
            idTextBudget.text = budgetEntity.number.toString()
            textDate.text = budgetEntity.date
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) viewStatus
                .setBackgroundColor(itemView.resources.getColor(color, null))
            else viewStatus
                .setBackgroundColor(itemView.resources.getColor(color))

            itemBudget.setOnClickListener {
                onClick.invoke(budgetEntity.id)
            }
        }
    }
}