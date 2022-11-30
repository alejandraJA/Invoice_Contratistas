package com.invoice.contratista.ui.fragment.receipt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.invoice.contratista.databinding.FragmentReceiptBinding

class ReceiptFragment : Fragment() {

    private lateinit var viewModel: ReceiptViewModel
    private lateinit var binding: FragmentReceiptBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReceiptBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[ReceiptViewModel::class.java]
        return binding.root
    }

}