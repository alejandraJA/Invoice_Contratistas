package com.invoice.contratista.ui.fragment.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.invoice.contratista.databinding.DiaryFragmentBinding

class DiaryFragment(private val id: String) : Fragment() {

    private lateinit var viewModel: EventViewModel
    private lateinit var binding: DiaryFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[EventViewModel::class.java]
        binding = DiaryFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}