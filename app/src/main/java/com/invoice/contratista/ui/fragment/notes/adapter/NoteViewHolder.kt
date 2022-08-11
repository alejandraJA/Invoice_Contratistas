package com.invoice.contratista.ui.fragment.notes.adapter

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.R
import com.invoice.contratista.data.local.entity.event.NoteEntity
import com.invoice.contratista.databinding.ItemNoteBinding

class NoteViewHolder(itemView: View, private val function: (NoteEntity) -> Unit) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemNoteBinding.bind(itemView)

    fun bind(noteEntity: NoteEntity) {
        binding.textNote.text = noteEntity.note
        binding.itemNote.setOnClickListener {
            function.invoke(noteEntity)
            itemView.findNavController().navigate(R.id.action_eventFragment_to_noteFragment)
        }
    }

}