package com.invoice.contratista.ui.fragment.budgets

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.invoice.contratista.data.local.entity.event.BudgetEntity
import com.invoice.contratista.databinding.FragmentBudgetsBinding
import com.invoice.contratista.ui.fragment.budgets.adapter.BudgetAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BudgetsFragment : Fragment() {

    private lateinit var binding: FragmentBudgetsBinding
    private lateinit var viewModel: BudgetsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBudgetsBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[BudgetsViewModel::class.java]
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val budgetList = mutableListOf<BudgetEntity>()
        val budgetAdapter = BudgetAdapter(budgetList) {

        }

        viewModel.budget.observe(viewLifecycleOwner) {
            budgetList.clear()
            budgetList.addAll(it)
            budgetAdapter.notifyDataSetChanged()
        }


        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = budgetAdapter
        }

    }

}