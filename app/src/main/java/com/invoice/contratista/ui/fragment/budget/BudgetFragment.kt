package com.invoice.contratista.ui.fragment.budget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.invoice.contratista.R
import com.invoice.contratista.databinding.FragmentBudgetBinding
import com.invoice.contratista.utils.Utils.getDate
import com.invoice.contratista.utils.Utils.getDateWithoutHour
import java.util.*

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val idBudget = UUID.randomUUID().toString()
        binding.textDate.text = Date().getDateWithoutHour()
        binding.idTextBudget.text = idBudget
        viewModel.insertIdBudget(idBudget)
        binding.buttonAddPart.setOnClickListener {
            findNavController().navigate(R.id.action_eventFragment_to_budgetFragment)
        }
    }

}