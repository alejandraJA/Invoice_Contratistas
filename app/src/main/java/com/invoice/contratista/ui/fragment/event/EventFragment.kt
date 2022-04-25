package com.invoice.contratista.ui.fragment.event

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.invoice.contratista.databinding.EventFragmentBinding
import java.text.SimpleDateFormat
import java.util.*

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

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calendarView = CalendarView(binding.datePicker)

        calendarView.setOnDataChanged {
            val simpleDateFormat = SimpleDateFormat("dd")
            val textNumbers = listOf(
                binding.textNumber1,
                binding.textNumber2,
                binding.textNumber3,
                binding.textNumber4,
                binding.textNumber5,
                binding.textNumber6,
                binding.textNumber7,
            )
            val list = setWeek(it.date)
            for (num in list.indices) {
                textNumbers[num].text = simpleDateFormat.format(list[num])
            }
        }
    }

    private fun setWeek(date: Date): List<Date> {
        val dayOfWeek = calendarView.getDayOfWeek(date)
        val datesOfWeek = mutableListOf<Date>()
        for (day in dayOfWeek downTo 1) datesOfWeek.add(calendarView.addDays(date, -day))
        datesOfWeek.add(date)
        for (day in 1..(6 - dayOfWeek)) datesOfWeek.add(calendarView.addDays(date, day))
        return datesOfWeek
    }

}