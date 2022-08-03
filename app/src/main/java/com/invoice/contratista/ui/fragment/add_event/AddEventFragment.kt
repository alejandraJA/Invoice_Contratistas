package com.invoice.contratista.ui.fragment.add_event

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.invoice.contratista.R
import com.invoice.contratista.databinding.AddEventFragmentBinding

class AddEventFragment : Fragment() {

    private lateinit var viewModel: AddEventViewModel
    private lateinit var binding: AddEventFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[AddEventViewModel::class.java]
        binding = AddEventFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonCreate.setOnClickListener {
            findNavController().navigate(R.id.action_addEventFragment_to_eventFragment)
        }
        binding.buttonAddCustomer.setOnClickListener {
            findNavController().navigate(R.id.action_addEventFragment_to_createCustomerFragment)
        }
    }

}