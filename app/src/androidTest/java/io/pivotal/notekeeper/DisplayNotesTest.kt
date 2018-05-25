package io.pivotal.notekeeper

import android.content.ComponentName
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.runner.AndroidJUnit4
import io.pivotal.notekeeper.note.details.NoteActivity
import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class DisplayNotesTest {

    @get:Rule
    var mActivityRule = IntentsTestRule<MainActivity>(MainActivity::class.java)

    val appContext = InstrumentationRegistry.getTargetContext()

    @Test
    fun displaysAListOfNotes() {
        // Context of the app under test.
        assertEquals("io.pivotal.notekeeper", appContext.packageName)

        onView(first(withId(R.id.card_title)))
                .check(matches(withText("Title 0")))
    }


    @Test
    fun displaysANote() {
        onView(first(withId(R.id.note_card))).perform(ViewActions.click())

        intended(hasComponent(ComponentName(appContext, NoteActivity::class.java)))
        onView(withId(R.id.note_title)).check(matches(withText("Title 0")))
    }

    // TODO: put this somewhere else
    private fun <T> first(matcher: Matcher<T>): Matcher<T> {
        return object : BaseMatcher<T>() {
            internal var isFirst = true

            override fun matches(item: Any): Boolean {
                if (isFirst && matcher.matches(item)) {
                    isFirst = false
                    return true
                }

                return false
            }

            override fun describeTo(description: Description) {
                description.appendText("should return first matching item")
            }
        }
    }
}
