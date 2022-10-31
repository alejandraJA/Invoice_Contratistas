package com.invoice.contratista.ui.fragment.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.invoice.contratista.R
import com.invoice.contratista.data.local.entity.CustomerEntity
import com.invoice.contratista.databinding.FragmentEventBinding
import com.invoice.contratista.ui.adapter.SectionsPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

private val TAB_TITLES = arrayOf(
    R.string.event,
    R.string.notes,
    R.string.schedule,
    R.string.budgets,
    R.string.receipt,
    R.string.invoice
)

@AndroidEntryPoint
class EventFragment : Fragment() {

    private lateinit var binding: FragmentEventBinding
    private lateinit var customerEntity: CustomerEntity
    private lateinit var viewModel: EventViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[EventViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionsPagerAdapter = SectionsPagerAdapter(requireActivity(), "")
        val viewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs

        viewModel.customer.observe(viewLifecycleOwner) {
            customerEntity = it
            binding.textNameCustomer.text = it.legal_name
            binding.buttonCall.setOnClickListener {

            }
            binding.buttonEmail.setOnClickListener {

            }
            binding.buttonMessage.setOnClickListener {

            }
        }

        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

    }

}