package com.invoice.contratista.ui.fragment.add_part

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.invoice.contratista.R
import com.invoice.contratista.databinding.FragmentAddPartBinding

class AddPartFragment : Fragment() {

    private lateinit var binding: FragmentAddPartBinding

    private lateinit var viewModel: AddPartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddPartBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[AddPartViewModel::class.java]
        return binding.root
    }

}