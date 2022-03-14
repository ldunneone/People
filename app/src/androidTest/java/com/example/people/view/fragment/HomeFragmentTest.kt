package com.example.people.view.fragment

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.people.R
import com.example.people.view.adapter.PersonViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {


    @Before
    fun setup(){
        launchFragmentInContainer(Bundle(), R.style.Theme_AppCompat) {
            HomeFragment()
        }
    }

    @Test
    fun test_isTitleTextViewVisible() {
        Espresso.onView(
            withId(R.id.people_list_textview)
        ).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test_isTitleTextViewCorrect(){
        Espresso.onView(
            withId(R.id.people_list_textview)
        ).check(ViewAssertions.matches(withText(R.string.people_list_text)))
    }

    @Test
    fun test_isRecyclerViewVisible(){
        Espresso.onView(
            withId(R.id.person_data_recyclerview)
        ).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun checkRecyclerViewHasItem(){
        Espresso.onView(
            withId(R.id.person_data_recyclerview)
        ).perform(
            RecyclerViewActions.actionOnItemAtPosition<PersonViewHolder>(0, ViewActions.click())
        )
    }
}