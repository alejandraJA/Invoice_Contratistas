package com.invoice.contratista.ui.fragment.notes.create

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.invoice.contratista.databinding.FragmentCreateEditNoteBinding
import com.invoice.contratista.utils.InputUtils.setText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateEditNoteFragment : Fragment() {

    private lateinit var binding: FragmentCreateEditNoteBinding
    private lateinit var viewModel: CreateEditNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[CreateEditNoteViewModel::class.java]
        binding = FragmentCreateEditNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.note.observe(viewLifecycleOwner) {
            if (binding.layoutNote.editText!!.text.toString().isEmpty())
                binding.layoutNote.setText(it)
        }
        binding.layoutNote.editText!!.addTextChangedListener { text: Editable? ->
            if (text!!.isNotEmpty() && text.length > 5) viewModel.updateNote(text.toString())
        }
    }

}