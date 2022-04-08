package com.invoice.contratista.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.invoice.contratista.R
import com.invoice.contratista.ui.fragment.budget.BudgetFragment
import com.invoice.contratista.ui.fragment.event.EventFragment
import com.invoice.contratista.ui.fragment.invoice.InvoiceFragment
import com.invoice.contratista.ui.fragment.receipt.ReceiptFragment

private val TAB_TITLES = arrayOf(
    R.string.visit,
    R.string.budget,
    R.string.receipt,
    R.string.invoice
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager, val id:String) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int) = when(position) {
        0 -> EventFragment(id)
        1 -> BudgetFragment(id)
        2 -> ReceiptFragment(id)
        3 -> InvoiceFragment(id)
        else -> EventFragment(id)
    }

    override fun getPageTitle(position: Int) = context.resources.getString(TAB_TITLES[position])


    override fun getCount() = TAB_TITLES.size

}