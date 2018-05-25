package io.pivotal.notekeeper.note.details

import android.content.Intent
import android.widget.TextView
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.pivotal.notekeeper.NoteKeeperApplication
import io.pivotal.notekeeper.R
import io.pivotal.notekeeper.note.Note
import io.pivotal.notekeeper.note.NoteService
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(application = TestFooApplication::class)
class NoteActivityTest {
    @Test
    fun `it loads the content of the note`() {
        val buildActivity = Robolectric.buildActivity(NoteActivity::class.java, Intent().putExtra("NOTE_ID", 42)).setup().get()

        assertThat(buildActivity.findViewById<TextView>(R.id.note_title).text.toString()).isEqualTo("Life, the Universe and Everything")
        assertThat(buildActivity.findViewById<TextView>(R.id.note_content).text.toString()).isEqualTo("So long and thanks for all the fish")
    }
}

class TestFooApplication : NoteKeeperApplication() {
    override var noteService = mock<NoteService> {
        on { note(42) } doReturn Note(42, "Life, the Universe and Everything", "So long and thanks for all the fish")
    }
}
