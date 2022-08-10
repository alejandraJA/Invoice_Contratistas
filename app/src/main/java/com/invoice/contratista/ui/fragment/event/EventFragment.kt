package com.invoice.contratista.ui.fragment.event

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.invoice.contratista.R
import com.invoice.contratista.databinding.FragmentEventBinding
import com.invoice.contratista.ui.adapter.SectionsPagerAdapter

private val TAB_TITLES = arrayOf(
    R.string.notes,
    R.string.schedule,
    R.string.budget,
    R.string.receipt,
    R.string.invoice
)

class EventFragment : Fragment() {

    private lateinit var binding: FragmentEventBinding

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

        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        requireActivity().onBackPressedDispatcher.addCallback {
            findNavController().navigate(R.id.action_eventFragment_to_navigation_home)
        }
    }

}