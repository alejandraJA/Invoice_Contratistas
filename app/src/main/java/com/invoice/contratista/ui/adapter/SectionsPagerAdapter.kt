package com.invoice.contratista.ui.adapter

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.invoice.contratista.R
import com.invoice.contratista.ui.fragment.budget.BudgetFragment
import com.invoice.contratista.ui.fragment.schedules.SchedulesFragment
import com.invoice.contratista.ui.fragment.invoice.InvoiceFragment
import com.invoice.contratista.ui.fragment.notes.NotesFragment
import com.invoice.contratista.ui.fragment.receipt.ReceiptFragment

private val TAB_TITLES = arrayOf(
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

    //override fun getPageTitle(position: Int) = context.resources.getString(TAB_TITLES[position])

    override fun getItemCount() = TAB_TITLES.size

    override fun createFragment(position: Int) = when(position) {
        0 -> NotesFragment()
        1 -> SchedulesFragment()
        2 -> BudgetFragment()
        3 -> ReceiptFragment()
        4 -> InvoiceFragment()
        else -> NotesFragment()
    }

}