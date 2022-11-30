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
import com.invoice.contratista.databinding.FragmentBudgetBinding
import com.invoice.contratista.ui.fragment.budget.adapter.PartAdapter
import com.invoice.contratista.ui.fragment.budget.adapter.PartItem
import com.invoice.contratista.utils.DateUtils.getDate
import com.invoice.contratista.utils.MoneyUtils.moneyFormat
import dagger.hilt.android.AndroidEntryPoint

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
        val partList = mutableListOf<PartItem>()
        val partAdapter = PartAdapter(partList) { idPart, idProduct ->
            viewModel.setPart(idPart, idProduct)
            findNavController().navigate(R.id.action_budgetFragment_to_addPartFragment)
        }
        viewModel.apply {
            budget.observe(viewLifecycleOwner) {
                binding.apply {
                    textDate.text = it.date.getDate()
                    idTextBudget.text = it.number.toString()
                    textSubtotal.text = it.subtotal.moneyFormat()
                    textTotal.text = it.total.moneyFormat()
                    textTotalGain.text = it.totalGain.moneyFormat()
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
                viewModel.createPart()
            }
            recyclerPart.apply {
                adapter = partAdapter
                setHasFixedSize(true)
            }
        }
    }

}