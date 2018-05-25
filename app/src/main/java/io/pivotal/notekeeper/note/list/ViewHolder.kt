package io.pivotal.notekeeper.note.list

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import io.pivotal.notekeeper.R.id.card_preview
import io.pivotal.notekeeper.R.id.card_title
import io.pivotal.notekeeper.note.Note

class ViewHolder(val view: ConstraintLayout, val listener: RecyclerViewClickListener?) : RecyclerView.ViewHolder(view), View.OnClickListener {
    override fun onClick(v: View) {
        listener?.recyclerViewListClicked(note.id)
    }

    var note = Note(-1, "", "")
        set(value) {
            view.findViewById<TextView>(card_title).text = value.title
            view.findViewById<TextView>(card_preview).text = value.text
            field = value
        }

    init {
        view.setOnClickListener(this)
    }
}