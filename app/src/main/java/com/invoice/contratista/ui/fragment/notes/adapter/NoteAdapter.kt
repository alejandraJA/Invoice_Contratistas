package com.invoice.contratista.ui.fragment.notes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.invoice.contratista.R
import com.invoice.contratista.data.source.local.entity.event.NoteEntity

class NoteAdapter(
    private val list: List<NoteEntity>,
    private val function: (NoteEntity) -> Unit
) : RecyclerView.Adapter<NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NoteViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false),
        function
    )

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount() = list.size
}