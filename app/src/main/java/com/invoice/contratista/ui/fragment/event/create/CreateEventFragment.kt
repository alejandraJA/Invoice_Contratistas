package com.invoice.contratista.ui.fragment.event.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.invoice.contratista.R
import com.invoice.contratista.data.source.local.entity.CustomerEntity
import com.invoice.contratista.databinding.FragmentCreateEventBinding
import com.invoice.contratista.utils.InputUtils.getTextWithValidation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateEventFragment : Fragment() {

    private lateinit var viewModel: CreateEventViewModel
    private lateinit var binding: FragmentCreateEventBinding
    private val customerNamesList = mutableListOf<String>()
    private val customerList = mutableListOf<CustomerEntity>()
    private var idCustomer = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[CreateEventViewModel::class.java]
        binding = FragmentCreateEventBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ArrayAdapter(requireContext(), R.layout.item_list, customerNamesList)
        binding.autoCompleteCustomer.setAdapter(adapter)
        viewModel.customer.observe(viewLifecycleOwner) {
            customerNamesList.clear()
            customerList.clear()
            customerList.addAll(it)
            customerList.forEach { customer ->
                customerNamesList.add(customer.legal_name)
            }
            adapter.setNotifyOnChange(true)
            binding.autoCompleteCustomer.setOnItemClickListener { _, _, position, _ ->
                idCustomer = customerList[position].id
            }
        }
        binding.buttonCancelEvent.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.buttonCreate.setOnClickListener {
            val nameEvent = binding.layoutName.getTextWithValidation()
            val note = binding.layoutNote.getTextWithValidation()
            if (idCustomer.isNotEmpty() && nameEvent.isNotEmpty() && note.isNotEmpty()) {
                viewModel.createEvent(idCustomer, note, nameEvent)
                findNavController().navigate(R.id.action_addEventFragment_to_eventFragment)
            }
        }
    }
}