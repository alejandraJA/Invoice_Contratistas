package com.invoice.contratista.ui.fragment.note

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.invoice.contratista.R
import com.invoice.contratista.databinding.FragmentNoteBinding

class NoteFragment : Fragment() {

    private lateinit var binding: FragmentNoteBinding
    private lateinit var viewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[NoteViewModel::class.java]
        binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}