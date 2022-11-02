package com.invoice.contratista.ui.fragment.budgets.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.R
import com.invoice.contratista.data.local.entity.event.BudgetEntity

class BudgetAdapter(
    private val listBudget: List<BudgetEntity>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<BudgetViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BudgetViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_budget, parent, false),
        onClick
    )

    override fun onBindViewHolder(holder: BudgetViewHolder, position: Int) {
        holder.bind(listBudget[position])
    }

    override fun getItemCount() = listBudget.size
}