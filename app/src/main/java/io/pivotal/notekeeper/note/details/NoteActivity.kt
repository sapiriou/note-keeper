package io.pivotal.notekeeper.note.details

import android.os.Bundle
import android.widget.TextView
import io.pivotal.notekeeper.BaseActivity
import io.pivotal.notekeeper.NoteKeeperApplication
import io.pivotal.notekeeper.R
import io.pivotal.notekeeper.note.NoteService
import kotlinx.android.synthetic.main.note_content.*

class NoteActivity : BaseActivity() {

    lateinit var noteService: NoteService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note_content)
        noteService = (this.application as NoteKeeperApplication).noteService

        setNote()
    }

    private fun setNote() {
        val note = noteService.note(intent.getIntExtra(NOTE_ID_EXTRA, NOTE_ID_DEFAULT))
        note_title.setText(note?.title, TextView.BufferType.EDITABLE)
        note_content.setText(note?.text, TextView.BufferType.EDITABLE)
    }

    companion object {
        val NOTE_ID_EXTRA = "NOTE_ID"
        val NOTE_ID_DEFAULT = -1
    }
}