package com.invoice.contratista.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.invoice.contratista.R
import com.invoice.contratista.data.local.entity.EventEntity
import com.invoice.contratista.data.local.entity.event.ScheduleEntity
import com.invoice.contratista.databinding.FragmentHomeBinding
import com.invoice.contratista.ui.fragment.home.apater.EventAdapter
import com.invoice.contratista.ui.fragment.schedule.adapter.ScheduleAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var viewModel: HomeViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listEvent = mutableListOf<EventEntity>()
        val listSchedule = mutableListOf<ScheduleEntity>()
        val adapterSchedule = ScheduleAdapter(listSchedule) {
            viewModel.setSchedule(idSchedule = it.id, action = false)
            findNavController().navigate(R.id.action_navigation_home_to_scheduleFragment)
        }
        val adapterEvent = EventAdapter(listEvent) { event ->
            viewModel.saveEvent(event)
        }
        binding.recyclerEvent.adapter = adapterEvent
        binding.recyclerEvent.setHasFixedSize(true)
        binding.recyclerEvent.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        binding.recyclerSchedule.adapter = adapterSchedule
        binding.recyclerSchedule.setHasFixedSize(true)
        binding.recyclerSchedule.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.buttonAddEvent.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_addEventFragment)
        }
        viewModel.event.observe(viewLifecycleOwner) {
            listEvent.clear()
            listEvent.addAll(it)
            adapterEvent.notifyDataSetChanged()
        }
        viewModel.schedule.observe(viewLifecycleOwner) {
            listSchedule.clear()
            listSchedule.addAll(it)
            adapterSchedule.notifyDataSetChanged()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}