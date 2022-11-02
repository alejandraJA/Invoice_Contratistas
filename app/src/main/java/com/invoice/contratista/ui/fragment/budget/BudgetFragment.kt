package com.invoice.contratista.ui.fragment.budget

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.invoice.contratista.R
import com.invoice.contratista.data.local.relations.Part
import com.invoice.contratista.databinding.FragmentBudgetBinding
import com.invoice.contratista.ui.fragment.budget.adapter.PartAdapter
import com.invoice.contratista.utils.Utils.getDate
import com.invoice.contratista.utils.Utils.getDateWithoutHour
import com.invoice.contratista.utils.Utils.setText
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class BudgetFragment : Fragment() {

    private lateinit var binding: FragmentBudgetBinding
    private lateinit var viewModel: BudgetViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBudgetBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[BudgetViewModel::class.java]
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val partList = mutableListOf<Part>()
        val partAdapter = PartAdapter(partList)
        viewModel.apply {
            budget.observe(viewLifecycleOwner) {
                val budgetEntity = it.budgetEntity!!
                binding.apply {
                    textDate.text = budgetEntity.date.getDate()
                    layoutTitle.setText("${resources.getString(R.string.budget)}_${budgetEntity.number}")
                    idTextBudget.text = budgetEntity.number.toString()
                }
            }
            parts.observe(viewLifecycleOwner) {
                partList.clear()
                partList.addAll(it)
                partAdapter.notifyDataSetChanged()
            }
        }
        binding.apply {
            buttonAddPart.setOnClickListener {
                findNavController().navigate(R.id.action_budgetFragment_to_addPartFragment)
            }
            recyclerPart.apply {
                adapter = partAdapter
                setHasFixedSize(true)
            }
        }
    }

}