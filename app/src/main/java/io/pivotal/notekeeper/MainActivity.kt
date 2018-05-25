package io.pivotal.notekeeper

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import io.pivotal.notekeeper.note.HardCodedNoteService
import io.pivotal.notekeeper.note.details.NoteActivity
import io.pivotal.notekeeper.note.list.NoteListAdapter
import io.pivotal.notekeeper.note.list.RecyclerViewClickListener
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val that = this
        setContentView(R.layout.content_main)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        note_list.layoutManager = LinearLayoutManager(this)
        note_list.adapter = NoteListAdapter((this.application as NoteKeeperApplication).noteService,
                object: RecyclerViewClickListener {
                    override fun recyclerViewListClicked(position: Int) {
                        startActivity(Intent(that, NoteActivity::class.java))
                        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    }
                })
    }
}

class Osef: Application() {

}