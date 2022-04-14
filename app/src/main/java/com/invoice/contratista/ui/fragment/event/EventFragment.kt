package com.invoice.contratista.ui.fragment.event

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.invoice.contratista.R
import com.invoice.contratista.databinding.DayItemBinding
import com.invoice.contratista.databinding.DayItemSelectedBinding
import com.invoice.contratista.databinding.EventFragmentBinding
import com.michalsvec.singlerowcalendar.calendar.CalendarChangesObserver
import com.michalsvec.singlerowcalendar.calendar.CalendarViewManager
import com.michalsvec.singlerowcalendar.calendar.SingleRowCalendarAdapter
import com.michalsvec.singlerowcalendar.selection.CalendarSelectionManager
import java.text.SimpleDateFormat
import java.util.*

class EventFragment(private val id: String) : Fragment() {

    private lateinit var viewModel: EventViewModel
    private lateinit var binding: EventFragmentBinding

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
        mutableListOf<DayItemBinding>()
        binding.datePicker.apply {
            calendarViewManager = object : CalendarViewManager {
                @SuppressLint("SimpleDateFormat")
                override fun bindDataToCalendarView(
                    holder: SingleRowCalendarAdapter.CalendarViewHolder,
                    date: Date,
                    position: Int,
                    isSelected: Boolean
                ) {
                    when (position) {
                        0 -> setDateInTextView(binding.textNumber1, binding.textName1, date)
                        1 -> setDateInTextView(binding.textNumber2, binding.textName2, date)
                        2 -> setDateInTextView(binding.textNumber3, binding.textName3, date)
                        3 -> setDateInTextView(binding.textNumber4, binding.textName4, date)
                        4 -> setDateInTextView(binding.textNumber5, binding.textName5, date)
                        5 -> setDateInTextView(binding.textNumber6, binding.textName6, date)
                        6 -> setDateInTextView(binding.textNumber7, binding.textName7, date)
                        else -> {}
                    }

                    if (isSelected) {
                        val day = DayItemSelectedBinding.bind(holder.itemView)
                        setDateInTextView(day.textDayItem, day.textNameDayItem, date)
                    } else {
                        val day = DayItemSelectedBinding.bind(holder.itemView)
                        setDateInTextView(day.textDayItem, day.textNameDayItem, date)
                    }
                }

                override fun setCalendarViewResourceId(
                    position: Int,
                    date: Date,
                    isSelected: Boolean
                ) = if (isSelected) R.layout.day_item_selected else R.layout.day_item

            }
            calendarChangesObserver = object : CalendarChangesObserver {
                override fun whenWeekMonthYearChanged(
                    weekNumber: String,
                    monthNumber: String,
                    monthName: String,
                    year: String,
                    date: Date
                ) {
                    super.whenWeekMonthYearChanged(weekNumber, monthNumber, monthName, year, date)
                    setDateInTextView(binding.textNumber1, binding.textName1, date)
                    setDateInTextView(binding.textNumber2, binding.textName2, addDays(date, 1))
                    setDateInTextView(binding.textNumber3, binding.textName3, addDays(date, 2))
                    setDateInTextView(binding.textNumber4, binding.textName4, addDays(date, 3))
                    setDateInTextView(binding.textNumber5, binding.textName5, addDays(date, 4))
                    setDateInTextView(binding.textNumber6, binding.textName6, addDays(date, 5))
                    setDateInTextView(binding.textNumber7, binding.textName7, addDays(date, 6))
                }
            }
            calendarSelectionManager = object : CalendarSelectionManager {
                override fun canBeItemSelected(position: Int, date: Date) = false
            }
            pastDaysCount = 7
            futureDaysCount = 7
            setDates(getDatesOfMoth())
            init()
        }
        getDatesOfMoth()
    }

    @SuppressLint("SimpleDateFormat")
    private fun getDatesOfMoth(): List<Date> {
        val list = mutableListOf<Date>()
        val simpleDateFormat = SimpleDateFormat("MM-dd-yyyy")
        val simpleDateFormatMonth = SimpleDateFormat("MM")
        val simpleDateFormatYear = SimpleDateFormat("yyyy")
        val month = simpleDateFormatMonth.format(Date())
        val year = simpleDateFormatYear.format(Date())
        for (day in 1 .. 30) {
            val date = simpleDateFormat.parse("$month-$day-$year")
            if (day == 1) {
                val decrement = (SimpleDateFormat("F").format(date)).toInt()
                for (num in decrement..1) {
                    list.add(addDays(Date(), -num))
                }
            }
            list.add(date)
        }
        return list
    }

    @SuppressLint("SimpleDateFormat")
    private fun setDateInTextView(textNumber: TextView, textName: TextView, date: Date) {
        val simpleDateFormat = SimpleDateFormat("dd")
        val simpleDateFormat2 = SimpleDateFormat("E")
        textName.text = simpleDateFormat2.format(date)
        textNumber.text = simpleDateFormat.format(date)
    }

    fun addDays(date: Date, days: Int): Date {
        val cal = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.DATE, days) //minus number would decrement the days
        return cal.time
    }

}