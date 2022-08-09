package com.invoice.contratista.ui.fragment.invoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.invoice.contratista.databinding.InvoiceFragmentBinding

class InvoiceFragment : Fragment() {

    private lateinit var viewModel: InvoiceViewModel
    private lateinit var binding: InvoiceFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = InvoiceFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[InvoiceViewModel::class.java]
        return binding.root
    }

}