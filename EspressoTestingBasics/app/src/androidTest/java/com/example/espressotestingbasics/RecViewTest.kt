package com.example.espressotestingbasics


import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.google.common.truth.Truth
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class RecViewTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    lateinit var validation : LoginValidations

    @Before
    fun init() {
        validation = LoginValidations()
    }

    @Test
    fun check_UserName_Normal() {
        Truth.assertThat(
            validation.isUserNameValid("abc")
        ).isAnyOf(
            true,
            false
        )
    }

    @Test
    fun check_UserName_Empty() {
        Truth.assertThat(
            validation.isUserNameValid("")
        ).isFalse()
    }

    @Test
    fun check_UserName_Valid_Length() {
        Truth.assertThat(
            validation.isUserNameValid("abc abc")
        ).isTrue()
    }

    @Test
    fun check_UserName_InValid_Length() {
        Truth.assertThat(
            validation.isUserNameValid("abc abc abc abc")
        ).isFalse()
    }

    @Test
    fun check_UserName_Contains_Hash_char() {
        Truth.assertThat(
            validation.isUserNameValid("#ddd")
        ).isFalse()
    }
    ////////////////////////////////////////////////////////////////
    @Test
    fun check_Password_Normal(){
        Truth.assertThat(
            validation.isPasswordValid("abc")
        ).isAnyOf(
            true,
            false
        )
    }
    @Test
    fun check_Password_LengthExed(){
        Truth.assertThat(
            validation.isPasswordValid("Balaviperu99")
        ).isFalse()
    }
    @Test
    fun check_Password_CorrectLength(){
        Truth.assertThat(
            validation.isPasswordValid("qwertyuu")
        ).isTrue()
    }
    @Test
    fun check_Password_SpecialChar(){
        Truth.assertThat(
            validation.isPasswordValid("Bala##")
        ).isTrue()
    }
    @Test
    fun check_Password_Numbers(){
        Truth.assertThat(
            validation.isPasswordValid("Bala10")
        ).isTrue()
    }
    @Test
    fun test_Login(){
        onView(withId(R.id.edtUser))
            .perform(
                replaceText("bala")
            )

       onView(withId(R.id.edtPass))
            .perform(
                typeText("bala10")
            )

        onView(
            withId(R.id.btnSubmit)
        ).perform(
            click()
        )

    }

    @Test
    fun checkBox_isWorking(){
        test_Login()
        onView(withId(R.id.checkBox))
            .check(
                matches(isDisplayed())
            )
    }

    @Test
    fun checkBox_isTrue(){
        test_Login()
        onView(withId(R.id.checkBox)).check(matches(isNotChecked())).perform(click())
    }

    @Test
    fun checkBox_isFalse(){
        test_Login()
        onView(withId(R.id.checkBox)).check(matches(isNotChecked())).perform(click())
        onView(withId(R.id.checkBox)).check(matches(isChecked())).perform(click())
    }

    @Test
    fun checkBox_RecView_Visible(){
        checkBox_isTrue()
        onView(withId(R.id.rec))
            .check(
                matches(isCompletelyDisplayed())
            )
    }

    @Test
    fun checkBox_RecView_InVisible(){
        checkBox_isFalse()
        onView(withId(R.id.rec))
            .check(
                matches(not(isCompletelyDisplayed()))
            )
    }

    @Test
    fun checkBox_RecView_ItemClicked(){
        checkBox_RecView_Visible()
                onView(
            withId(R.id.rec)
        ).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecVh>(
                0,
                click()
            )
        )
    }
}