package com.invoice.contratista.ui.adapter

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.invoice.contratista.R
import com.invoice.contratista.ui.fragment.budget.BudgetFragment
import com.invoice.contratista.ui.fragment.event.data.EventDataFragment
import com.invoice.contratista.ui.fragment.schedule.ScheduleFragment
import com.invoice.contratista.ui.fragment.invoice.InvoiceFragment
import com.invoice.contratista.ui.fragment.notes.NotesFragment
import com.invoice.contratista.ui.fragment.receipt.ReceiptFragment

private val TAB_TITLES = arrayOf(
    R.string.event,
    R.string.notes,
    R.string.schedule,
    R.string.budget,
    R.string.receipt,
    R.string.invoice
)

/**
 * A [FragmentStateAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(fragmentActivity: FragmentActivity, val id: String) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = TAB_TITLES.size

    override fun createFragment(position: Int) = when(position) {
        0 -> EventDataFragment()
        1 -> NotesFragment()
        2 -> ScheduleFragment()
        3 -> BudgetFragment()
        4 -> ReceiptFragment()
        5 -> InvoiceFragment()
        else -> EventDataFragment()
    }

}