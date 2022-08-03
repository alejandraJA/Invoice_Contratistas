package com.invoice.contratista.ui.fragment.customer.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.invoice.contratista.databinding.CreateCustomerFragmentBinding

class CreateCustomerFragment : Fragment() {

    private lateinit var binding: CreateCustomerFragmentBinding
    private lateinit var viewModel: CreateCustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[CreateCustomerViewModel::class.java]
        binding = CreateCustomerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

}