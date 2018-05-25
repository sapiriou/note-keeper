package io.pivotal.notekeeper.note.list

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.pivotal.notekeeper.R
import io.pivotal.notekeeper.note.NoteService


class NoteListAdapter(
        private val noteService: NoteService,
        private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.note_card, parent, false) as ConstraintLayout
        return ViewHolder(view, listener)
    }

    override fun getItemCount() = noteService.notes.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.note = noteService.notes[position]
    }
}

interface RecyclerViewClickListener {
    fun recyclerViewListClicked(position: Int)
}

