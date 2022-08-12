package com.invoice.contratista.ui.fragment.part

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.invoice.contratista.databinding.FragmentPartBinding

class PartFragment : Fragment() {

    private lateinit var binding: FragmentPartBinding
    private lateinit var viewModel: PartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPartBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[PartViewModel::class.java]
        return binding.root
    }

}