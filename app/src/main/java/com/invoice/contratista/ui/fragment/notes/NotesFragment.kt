package com.invoice.contratista.ui.fragment.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.invoice.contratista.R
import com.invoice.contratista.data.source.local.entity.event.NoteEntity
import com.invoice.contratista.databinding.FragmentNotesBinding
import com.invoice.contratista.ui.fragment.notes.adapter.NoteAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        val listNotes = mutableListOf<NoteEntity>()
        val adapter = NoteAdapter(listNotes) {
            viewModel.setNote(it)
        }
        binding.buttonAddNote.setOnClickListener {
            viewModel.createNote()
            findNavController().navigate(R.id.action_eventFragment_to_noteFragment)
        }
        binding.recyclerNote.setHasFixedSize(true)
        binding.recyclerNote.adapter = adapter

        viewModel.notes.observe(viewLifecycleOwner) {
            listNotes.clear()
            listNotes.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }

}