package com.invoice.contratista.ui.fragment.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.invoice.contratista.R
import com.invoice.contratista.data.source.local.entity.event.ScheduleEntity
import com.invoice.contratista.databinding.FragmentScheduleBinding
import com.invoice.contratista.ui.fragment.schedule.adapter.ScheduleAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScheduleFragment : Fragment() {

    private lateinit var viewModel: ScheduleViewModel
    private lateinit var binding: FragmentScheduleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[ScheduleViewModel::class.java]
        binding = FragmentScheduleBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listSchedule = mutableListOf<ScheduleEntity>()
        val adapter = ScheduleAdapter(listSchedule) {
            findNavController().navigate(R.id.action_eventFragment_to_scheduleFragment)
            viewModel.setSchedule(it.id, false)
        }
        binding.buttonAddSchedule.setOnClickListener {
            findNavController().navigate(R.id.action_eventFragment_to_scheduleFragment)
            viewModel.setSchedule("0", true)
        }
        binding.recyclerSchedule.setHasFixedSize(true)
        binding.recyclerSchedule.adapter = adapter
        viewModel.schedule.observe(viewLifecycleOwner) {
            listSchedule.clear()
            listSchedule.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }

}