package io.pivotal.notekeeper.note.list

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import io.pivotal.notekeeper.R.id.card_preview
import io.pivotal.notekeeper.R.id.card_title
import io.pivotal.notekeeper.note.Note

class ViewHolder(val view: ConstraintLayout) : RecyclerView.ViewHolder(view) {
    var note = Note(-1, "", "")
        set(value) {
            view.findViewById<TextView>(card_title).text = value.title
            view.findViewById<TextView>(card_preview).text = value.text
            field = value
        }
}