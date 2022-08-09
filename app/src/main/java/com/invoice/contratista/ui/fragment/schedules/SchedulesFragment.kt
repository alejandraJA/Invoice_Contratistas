package com.invoice.contratista.ui.fragment.schedules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.invoice.contratista.R
import com.invoice.contratista.databinding.SchedulesFragmentBinding

class SchedulesFragment : Fragment() {

    private lateinit var viewModel: SchedulesViewModel
    private lateinit var binding: SchedulesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[SchedulesViewModel::class.java]
        binding = SchedulesFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAddSchedule.setOnClickListener {
            findNavController().navigate(R.id.action_eventFragment_to_scheduleFragment)
        }
    }

}