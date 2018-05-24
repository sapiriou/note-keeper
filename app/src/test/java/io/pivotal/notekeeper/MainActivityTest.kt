package io.pivotal.notekeeper

import android.support.v7.widget.RecyclerView
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    @Test
    fun `displays a list of cards`() {
        val mainActivity = Robolectric.setupActivity(MainActivity::class.java)
        val recyclerView: RecyclerView = mainActivity.findViewById(R.id.note_list)
        assertThat(recyclerView).isNotNull
        assertThat(recyclerView.childCount).isGreaterThan(1)
    }
}
