package com.invoice.contratista.ui.fragment.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.invoice.contratista.databinding.EventFragmentBinding


class EventFragment(private val id: String) : Fragment() {

    private lateinit var viewModel: EventViewModel
    private lateinit var binding: EventFragmentBinding
    private lateinit var calendarView: CalendarView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[EventViewModel::class.java]
        binding = EventFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calendarView = CalendarView(binding.datePicker)
    }

    override fun onResume() {
        super.onResume()
        calendarView.onStart()
    }

}