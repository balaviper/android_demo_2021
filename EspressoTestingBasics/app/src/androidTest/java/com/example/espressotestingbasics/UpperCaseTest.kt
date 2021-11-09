package com.example.espressotestingbasics

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.Button
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.EnumSet.allOf


@RunWith(AndroidJUnit4::class)
@LargeTest
class FirstFragmentTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    val customMatcher = object : BoundedMatcher<View?, Button>(Button::class.java) {
        override fun matchesSafely(btn: Button): Boolean {
            val bgCl = btn.background as ColorDrawable
            return bgCl.color == Color.RED
        }

        override fun describeTo(description: Description) {
            description.appendText("with text color: ")
        }
    }

    @Test
    fun test_Next_Button_Loaded() {
        onView(withText("NEXT"))
            .check(
                matches(isCompletelyDisplayed())
            )
    }

    @Test
    fun test_EditText_Loaded() {
        onView(withId(R.id.editTextTextPersonName))
            .check(
                matches(isCompletelyDisplayed())
            )
    }

    @Test
    fun test_UpperCase(){
        onView(withId(R.id.editTextTextPersonName)).perform(replaceText("bala"))
        onView(withId(R.id.btnUpr)).perform(click())
        onView(withId(R.id.editTextTextPersonName)).check(matches(withText("BALA")))
    }

    @Test
    fun test_UpperCase_Number(){
        onView(withId(R.id.editTextTextPersonName)).perform(replaceText("bala07hgf"))
        onView(withId(R.id.btnUpr)).perform(click())
        onView(withId(R.id.editTextTextPersonName)).check(matches(withText("BALA07HGF")))
    }
    @Test
    fun test_UpperCase_AlreadyUpper(){
        onView(withId(R.id.editTextTextPersonName)).perform(replaceText("ASDFGH"))
        onView(withId(R.id.btnUpr)).perform(click())
        onView(withId(R.id.editTextTextPersonName)).check(matches(withText("ASDFGH")))
    }
    @Test
    fun test_UpperCase_SpecialSymbols(){
        onView(withId(R.id.editTextTextPersonName)).perform(replaceText("r#$%^&"))
        onView(withId(R.id.btnUpr)).perform(click())
        onView(withId(R.id.editTextTextPersonName)).check(matches(withText("R#$%^&")))
    }
    @Test
    fun test_UpperCase_Negative(){
        onView(withId(R.id.editTextTextPersonName)).perform(replaceText("-2345"))
        onView(withId(R.id.btnUpr)).perform(click())
        onView(withId(R.id.editTextTextPersonName)).check(matches(withText("-2345")))
    }
    @Test
    fun test_UpperCase_Click(){
        val message = "Enter something Idiot"
        onView(withId(R.id.btnUpr)).perform(click())
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(message)))
        onView(withId(R.id.editTextTextPersonName)).perform(replaceText("r#$%^&"))
        onView(withId(R.id.btnUpr)).perform(click())
        onView(withId(R.id.editTextTextPersonName)).check(matches(withText("R#$%^&")))
    }
    @Test
    fun check_color() {
        onView(
            withId(R.id.btnUpr)
        ).check(
            matches(
                customMatcher
            )
        )
    }

}