package com.invoice.contratista.calendar

import android.annotation.SuppressLint
import android.os.Build
import android.view.View
import com.invoice.contratista.R
import com.invoice.contratista.databinding.LayoutCalendarBinding
import com.invoice.contratista.databinding.ItemDayBinding
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
class CalendarView(private val binding: LayoutCalendarBinding) {
    private var dateSelected: DayItem
    private var currentDate = Date()
    private var dayViews: List<ItemDayBinding>
    private var dates: List<DayItem> = listOf()
    private var stateMotion = false
    private var monthSelected: Int = 0
    private var yearSelected: Int = 0
    private lateinit var days: (DayItem) -> Unit

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
                days.invoke(dates[0])
            }
            text02.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_first_constraint)
                days.invoke(dates[1])
            }
            text03.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_first_constraint)
                days.invoke(dates[2])
            }
            text04.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_first_constraint)
                days.invoke(dates[3])
            }
            text05.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_first_constraint)
                days.invoke(dates[4])
            }
            text06.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_first_constraint)
                days.invoke(dates[5])
            }
            text07.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_first_constraint)
                days.invoke(dates[6])
            }
            text08.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_second_constraint)
                days.invoke(dates[7])
            }
            text09.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_second_constraint)
                days.invoke(dates[8])
            }
            text10.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_second_constraint)
                days.invoke(dates[9])
            }
            text11.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_second_constraint)
                days.invoke(dates[10])
            }
            text12.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_second_constraint)
                days.invoke(dates[11])
            }
            text13.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_second_constraint)
                days.invoke(dates[12])
            }
            text14.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_second_constraint)
                days.invoke(dates[13])
            }
            text15.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_third_constraint)
                days.invoke(dates[14])
            }
            text16.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_third_constraint)
                days.invoke(dates[15])
            }
            text17.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_third_constraint)
                days.invoke(dates[16])
            }
            text18.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_third_constraint)
                days.invoke(dates[17])
            }
            text19.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_third_constraint)
                days.invoke(dates[18])
            }
            text20.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_third_constraint)
                days.invoke(dates[19])
            }
            text21.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_third_constraint)
                days.invoke(dates[20])
            }
            text22.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fourth_constraint)
                days.invoke(dates[21])
            }
            text23.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fourth_constraint)
                days.invoke(dates[22])
            }
            text24.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fourth_constraint)
                days.invoke(dates[23])
            }
            text25.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fourth_constraint)
                days.invoke(dates[24])
            }
            text26.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fourth_constraint)
                days.invoke(dates[25])
            }
            text27.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fourth_constraint)
                days.invoke(dates[26])
            }
            text28.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fourth_constraint)
                days.invoke(dates[27])
            }
            text29.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fifth_constraint)
                days.invoke(dates[28])
            }
            text30.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fifth_constraint)
                days.invoke(dates[29])
            }
            text31.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fifth_constraint)
                days.invoke(dates[30])
            }
            text32.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fifth_constraint)
                days.invoke(dates[31])
            }
            text33.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fifth_constraint)
                days.invoke(dates[32])
            }
            text34.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fifth_constraint)
                days.invoke(dates[33])
            }
            text35.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_fifth_constraint)
                days.invoke(dates[34])
            }
            text36.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_sixth_constraint)
                days.invoke(dates[35])
            }
            text37.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_sixth_constraint)
                days.invoke(dates[36])
            }
            text38.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_sixth_constraint)
                days.invoke(dates[37])
            }
            text42.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_sixth_constraint)
                days.invoke(dates[38])
            }
            text39.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_sixth_constraint)
                days.invoke(dates[39])
            }
            text40.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_sixth_constraint)
                days.invoke(dates[40])
            }
            text41.itemItem.setOnClickListener {
                setTransition(R.id.start, R.id.to_sixth_constraint)
                days.invoke(dates[41])
            }
            dateSelected = DayItem(
                "",
                currentDate,
                true,
                View.VISIBLE,
                true
            )
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
                monthSelected = SimpleDateFormat("MM").format(currentDate).toInt()
                yearSelected = SimpleDateFormat("yyyy").format(currentDate).toInt()
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

    fun setOnDataChanged(days: (DayItem) -> Unit) {
        this.days = days
        days.invoke(dateSelected)
    }

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    private fun getDatesOfMoth(month: Int, year: Int): List<DayItem> {
        val days = mutableListOf<DayItem>()
        val formatDate = SimpleDateFormat("MM-dd-yyyy")
        val initialDate = formatDate.parse("$month-1-$year")!!
        binding.textMonth.text = "${SimpleDateFormat("MMMM").format(initialDate)} $year"
        val formatMonth = SimpleDateFormat("MM")

        for (i in 1..31) {

            val dayOfWeek =
                if (getDayOfWeek(initialDate) == 7) 0
                else getDayOfWeek(initialDate)
            if (i == 1) {
                for (num in dayOfWeek downTo 1) days.add(
                    DayItem(
                        "",
                        addDays(initialDate, -num),
                        (formatDate.format(
                            addDays(
                                initialDate,
                                -num
                            )
                        ) == formatDate.format(Date())),
                        View.INVISIBLE,
                        (month == formatMonth.format(addDays(initialDate, -num))
                            .toString().toInt())
                    )
                )
                days.add(
                    DayItem(
                        "",
                        initialDate,
                        false,
                        View.VISIBLE,
                        (month == formatMonth.format(initialDate).toString().toInt())
                    )
                )
            }
            val date1: Date = addDays(initialDate, i)
            days.add(
                DayItem(
                    "",
                    date1,
                    (formatDate.format(date1) == formatDate.format(Date())),
                    View.VISIBLE,
                    (month == formatMonth.format(date1).toString().toInt())
                )
            )
        }
        var date = days[days.size - 1]
        while (days.size < 42) {
            days.add(
                DayItem(
                    "",
                    addDays(date.date, 1),
                    false,
                    View.INVISIBLE,
                    (month == formatMonth.format(addDays(date.date, 1)).toString().toInt())
                )
            )
            date = days[days.size - 1]
        }
        return days
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
            datesOfMoth[num].day = SimpleDateFormat("dd").format(datesOfMoth[num].date)
            datesOfMoth[num].visibility =
                if (!datesOfMoth[num].currentMoth) {
                    if (num >= 35 && stateSixConstraint)
                        View.GONE
                    else
                        View.INVISIBLE
                } else {
                    if (num >= 35)
                        stateSixConstraint = false
                    View.VISIBLE
                }
            dayViews[num].day = datesOfMoth[num]
        }
    }

    @SuppressLint("SimpleDateFormat")
    fun getDayOfWeek(date: Date?) =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
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

}