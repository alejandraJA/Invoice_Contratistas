package com.invoice.contratista.ui.fragment.event

import android.annotation.SuppressLint
import android.os.Build
import android.view.View
import com.invoice.contratista.R
import com.invoice.contratista.databinding.CalendarViewBinding
import com.invoice.contratista.databinding.DayItemBinding
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
class CalendarView(private val binding: CalendarViewBinding) {
    private var dateSelected: DayItem
    private var dayViews: List<DayItemBinding>
    private var dates: List<DayItem> = listOf()
    private var stateMotion = false
    private var monthSelected: Int = 0
    private var yearSelected: Int = 0

    init {
        binding.apply {
            dayViews = listOf(
                text01,
                text02,
                text03,
                text04,
                text05,
                text06,
                text07,
                text08,
                text09,
                text10,
                text11,
                text12,
                text13,
                text14,
                text15,
                text16,
                text17,
                text18,
                text19,
                text20,
                text21,
                text22,
                text23,
                text24,
                text25,
                text26,
                text27,
                text28,
                text29,
                text30,
                text31,
                text32,
                text33,
                text34,
                text35,
                text36,
                text37,
                text38,
                text39,
                text40,
                text41,
                text42,
            )
            monthSelected = SimpleDateFormat("MM").format(Date()).toInt()
            yearSelected = SimpleDateFormat("yyyy").format(Date()).toInt()
            dates = getDatesOfMoth(monthSelected, yearSelected)
            motionBase.setTransitionDuration(1000)
            text01.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_first_constraint)
                dateSelected = dates[0]
            }
            text02.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_first_constraint)
                dateSelected = dates[1]
            }
            text03.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_first_constraint)
                dateSelected = dates[2]
            }
            text04.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_first_constraint)
                dateSelected = dates[3]
            }
            text05.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_first_constraint)
                dateSelected = dates[4]
            }
            text06.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_first_constraint)
                dateSelected = dates[5]
            }
            text07.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_first_constraint)
                dateSelected = dates[6]
            }
            text08.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_second_constraint)
                dateSelected = dates[7]
            }
            text09.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_second_constraint)
                dateSelected = dates[8]
            }
            text10.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_second_constraint)
                dateSelected = dates[9]
            }
            text11.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_second_constraint)
                dateSelected = dates[10]
            }
            text12.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_second_constraint)
                dateSelected = dates[11]
            }
            text13.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_second_constraint)
                dateSelected = dates[12]
            }
            text14.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_second_constraint)
                dateSelected = dates[13]
            }
            text15.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_third_constraint)
                dateSelected = dates[14]
            }
            text16.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_third_constraint)
                dateSelected = dates[15]
            }
            text17.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_third_constraint)
                dateSelected = dates[16]
            }
            text18.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_third_constraint)
                dateSelected = dates[17]
            }
            text19.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_third_constraint)
                dateSelected = dates[18]
            }
            text20.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_third_constraint)
                dateSelected = dates[19]
            }
            text21.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_third_constraint)
                dateSelected = dates[20]
            }
            text22.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fourth_constraint)
                dateSelected = dates[21]
            }
            text23.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fourth_constraint)
                dateSelected = dates[22]
            }
            text24.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fourth_constraint)
                dateSelected = dates[23]
            }
            text25.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fourth_constraint)
                dateSelected = dates[24]
            }
            text26.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fourth_constraint)
                dateSelected = dates[25]
            }
            text27.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fourth_constraint)
                dateSelected = dates[26]
            }
            text28.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fourth_constraint)
                dateSelected = dates[27]
            }
            text29.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fifth_constraint)
                dateSelected = dates[28]
            }
            text30.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fifth_constraint)
                dateSelected = dates[29]
            }
            text31.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fifth_constraint)
                dateSelected = dates[30]
            }
            text32.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fifth_constraint)
                dateSelected = dates[31]
            }
            text33.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fifth_constraint)
                dateSelected = dates[32]
            }
            text34.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fifth_constraint)
                dateSelected = dates[33]
            }
            text35.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fifth_constraint)
                dateSelected = dates[34]
            }
            text36.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_sixth_constraint)
                dateSelected = dates[35]
            }
            text37.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_sixth_constraint)
                dateSelected = dates[36]
            }
            text38.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_sixth_constraint)
                dateSelected = dates[37]
            }
            text42.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_sixth_constraint)
                dateSelected = dates[38]
            }
            text39.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_sixth_constraint)
                dateSelected = dates[39]
            }
            text40.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_sixth_constraint)
                dateSelected = dates[40]
            }
            text41.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_sixth_constraint)
                dateSelected = dates[41]
            }
            dateSelected = DayItem("", Date(), true, View.VISIBLE)
            more.setOnClickListener {
                stateMotion = if (stateMotion) {
                    binding.motionBase.transitionToStart()
                    false
                } else {
                    binding.motionBase.transitionToEnd()
                    true
                }
            }
            navigateToNext.setOnClickListener {
                if (monthSelected == 12) {
                    monthSelected = 1
                    yearSelected++
                } else {
                    monthSelected++
                }
                dates = getDatesOfMoth(monthSelected, yearSelected)
                setCalendar(dates)
            }
            navigateToPrevious.setOnClickListener {
                if (monthSelected == 1) {
                    monthSelected = 12
                    yearSelected--
                } else {
                    monthSelected--
                }
                dates = getDatesOfMoth(monthSelected, yearSelected)
                setCalendar(dates)
            }
            navigateToSelected.setOnClickListener {
                monthSelected = SimpleDateFormat("MM").format(dateSelected.date).toInt()
                yearSelected = SimpleDateFormat("yyyy").format(dateSelected.date).toInt()
                dates = getDatesOfMoth(monthSelected, yearSelected)
                setCalendar(dates)
                if (stateMotion) {
                    binding.motionBase.transitionToStart()
                    stateMotion = false
                }
            }
        }
        setCalendar(dates)
    }

    fun onStart() {
        setCalendar(dates)
    }

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    private fun getDatesOfMoth(month: Int, year: Int): List<DayItem> {
        val list = mutableListOf<DayItem>()
        val initialDate = SimpleDateFormat("MM-dd-yyyy").parse("$month-1-$year")!!
        binding.textMonth.text = "${SimpleDateFormat("MMMM").format(initialDate)} $year"

        for (i in 1..31) {
            val dayOfWeek = getDayOfWeek(initialDate)
            if (i == 1) {
                for (num in dayOfWeek downTo 1) list.add(
                    DayItem(
                        "",
                        addDays(initialDate, -num),
                        false,
                        View.INVISIBLE
                    )
                )
                list.add(DayItem("", initialDate, true, View.VISIBLE))
            }
            val date1: Date = addDays(initialDate, i)
            list.add(DayItem("", date1, true, View.VISIBLE))
        }
        var date = list[list.size - 1]
        while (list.size < 42) {
            list.add(
                DayItem(
                    "",
                    addDays(date.date, 1),
                    false,
                    View.INVISIBLE
                )
            )
            date = list[list.size - 1]
        }
        return list
    }

    private fun setTransition(start: Int, end: Int) {
        stateMotion = if (stateMotion) {
            binding.motionBase.transitionToStart()
            false
        } else {
            binding.motionBase.setTransitionDuration(1000)
            binding.motionBase.setTransition(start, end)
            binding.motionBase.transitionToEnd()
            true
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun setCalendar(datesOfMoth: List<DayItem>) {
        var stateSixConstraint = true
        for (num in datesOfMoth.indices) {
            dayViews[num].textDayItem.text = SimpleDateFormat("dd").format(datesOfMoth[num].date)
            val formatMonth = SimpleDateFormat("MM")
            val month =
                formatMonth.format(datesOfMoth[num].date) != formatMonth.format(datesOfMoth[15].date)
            dayViews[num].itemItem.visibility =
                if (month) {
                    if (num >= 35 && stateSixConstraint)
                        View.GONE
                    else View.INVISIBLE
                } else {
                    if (num >= 35)
                        stateSixConstraint = false
                    View.VISIBLE
                }

        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun getDayOfWeek(date: Date?) = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        (SimpleDateFormat("u").format(date!!)).toInt()
    } else {
        when ((SimpleDateFormat("E").format(date!!))) {
            "Mon" -> 1
            "Tue" -> 2
            "Wed" -> 3
            "Thu" -> 4
            "Fri" -> 5
            "Sat" -> 6
            "Sun" -> 7
            "lun." -> 1
            "mar." -> 2
            "mié." -> 3
            "jue." -> 4
            "vie." -> 5
            "sab." -> 6
            "dom." -> 7
            else -> 1
        }
    }

    private fun addDays(date: Date, days: Int): Date {
        val cal = Calendar.getInstance()
        cal.time = date
        cal.add(Calendar.DATE, days)
        return cal.time
    }

    /*@SuppressLint("SimpleDateFormat")
    private fun setWeek() {
        val dayOfWeek = getDayOfWeek(dateSelected)
        val datesOfWeek = mutableListOf<Date>()
        val textViews = listOf(
            binding.text01,
            binding.text02,
            binding.text03,
            binding.text04,
            binding.text05,
            binding.text06,
            binding.text07,
        )
        for (day in dayOfWeek downTo 1) datesOfWeek.add(addDays(dateSelected, -day))
        datesOfWeek.add(dateSelected)
        for (day in 1..(6 - dayOfWeek)) datesOfWeek.add(addDays(dateSelected, day))
        for (num in textViews.indices) {
            textViews[num].text = SimpleDateFormat("dd").format(datesOfWeek[num])
            val formatMonth = SimpleDateFormat("MM")
            val month = formatMonth.format(datesOfWeek[num]) != formatMonth.format(dateSelected)
            textViews[num].visibility =
                if (month) {
                    if (num >= 36) View.GONE
                    else View.INVISIBLE
                } else View.VISIBLE
        }
    }*/
}