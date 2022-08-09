package com.invoice.contratista.ui.fragment.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.invoice.contratista.R
import com.invoice.contratista.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

    private lateinit var binding: FragmentNotesBinding
    private lateinit var viewModel: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotesBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[NotesViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAddNote.setOnClickListener {
            findNavController().navigate(R.id.action_eventFragment_to_noteFragment)
        }
    }

}