package com.invoice.contratista.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.invoice.contratista.config.GlobalVariables
import com.invoice.contratista.databinding.FragmentHomeBinding
import com.invoice.contratista.ui.fragment.home.apater.Event
import com.invoice.contratista.ui.fragment.home.apater.EventAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var homeViewModel: HomeViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = EventAdapter(
            listOf(
                Event(
                    "",
                    "Alejandra",
                    "Descripcion improvisada",
                    "Receipt",
                    GlobalVariables.Priority.Important,
                    "12/04/2021",
                    "12:07"
                ),
                Event(
                    "",
                    "Abraham",
                    "Descripcion improvisada",
                    "Invoice",
                    GlobalVariables.Priority.Important,
                    "8/04/2021",
                    "12:07"
                )
            )
        )
        binding.recyclerEvent.adapter = adapter
        binding.recyclerEvent.setHasFixedSize(true)
        binding.recyclerEvent.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}