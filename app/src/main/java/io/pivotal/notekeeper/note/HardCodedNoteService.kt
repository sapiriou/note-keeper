package io.pivotal.notekeeper.note

import java.util.*

interface NoteService {
    val notes: List<Note>
    fun note(id: Int): Note?
}

class HardCodedNoteService: NoteService {
    override fun note(id: Int): Note? {
        return notes.find { it.id == id }
    }

    override val notes: List<Note> = (0..19).map { Note(it, "Title $it", makeRandomNoteContent()) }

    companion object {
    private val sampleText = """Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vulputate sodales odio sit amet vestibulum. Aliquam vel libero lacinia, mollis nisi non, vestibulum nunc. Nam sagittis enim eget enim hendrerit fermentum. Mauris lobortis gravida viverra. Maecenas non orci quis metus mollis tincidunt. Sed luctus bibendum ante iaculis vestibulum. Nunc malesuada nibh vel neque condimentum, quis pretium tellus convallis. Suspendisse sed pretium lorem, ac consectetur dui. Nam gravida nunc mauris, non congue sem pharetra quis. Integer varius erat ac lectus facilisis, bibendum imperdiet leo cursus.

Donec ac placerat quam. Etiam sed vehicula nisl. Interdum et malesuada fames ac ante ipsum primis in faucibus. Suspendisse tincidunt sem pellentesque enim suscipit pharetra. Vestibulum lobortis ullamcorper libero a blandit. In non feugiat massa. Etiam luctus eros lacus, a auctor nulla pulvinar eu. Integer eget dapibus massa, vitae viverra enim. Nullam velit dolor, tincidunt quis neque nec, ultrices tempus nisl. Pellentesque ultricies quis urna id commodo. Aenean interdum aliquet eros eu faucibus.

Sed vel luctus justo. Donec nulla lectus, tempor id urna eget, egestas auctor dolor. Duis bibendum finibus eros at tincidunt. Duis a pharetra lorem, quis iaculis nisi. Fusce sodales risus quis sollicitudin elementum. Nullam bibendum ultricies odio nec viverra. Nulla facilisi. Duis venenatis hendrerit sapien eget ornare. Fusce eu vestibulum metus. Proin finibus ipsum volutpat dolor varius, egestas condimentum ante accumsan. Donec et nibh massa. Nullam posuere posuere egestas. Morbi nec leo in sapien consectetur faucibus sed eu felis."""
    }

    private fun makeRandomNoteContent(): String {
        val words = sampleText.split(Regex("\\s"))
        val startingPoint = Random().nextInt(words.size / 2)
        return words.drop(startingPoint).take(100).joinToString(" ").capitalize()
    }
}
