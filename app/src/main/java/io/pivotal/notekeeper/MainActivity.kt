package io.pivotal.notekeeper

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.pivotal.notekeeper.note.NoteService
import io.pivotal.notekeeper.note.list.NoteListAdapter
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        note_list.layoutManager = LinearLayoutManager(this)
        note_list.adapter = NoteListAdapter(NoteService.instance)
    }
}
