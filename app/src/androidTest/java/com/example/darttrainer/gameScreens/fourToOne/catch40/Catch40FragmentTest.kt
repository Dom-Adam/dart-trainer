package com.example.darttrainer.gameScreens.fourToOne.catch40

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.darttrainer.R
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@RunWith(AndroidJUnit4::class)
class Catch40FragmentTest {

    @Test
    fun pressingButton1_displays3PointsAndNextTarget() {
        val scenario = launchFragmentInContainer<Catch40Fragment>(null, R.style.Theme_DartTrainer)

        onView(withId(R.id.ten_button_one)).perform(click())
        onView(withId(R.id.one_target_main)).check(matches(withText("62")))
        onView(withId(R.id.one_target_secondary)).check(matches(withText("3")))
    }

    @Test
    fun pressingButton2_displays2PointsAndNextTarget() {
        val scenario = launchFragmentInContainer<Catch40Fragment>(null, R.style.Theme_DartTrainer)

        onView(withId(R.id.ten_button_two)).perform(click())
        onView(withId(R.id.one_target_main)).check(matches(withText("62")))
        onView(withId(R.id.one_target_secondary)).check(matches(withText("2")))
    }

    @Test
    fun pressingButton3_displays1PointAndNextTarget() {
        val scenario = launchFragmentInContainer<Catch40Fragment>(null, R.style.Theme_DartTrainer)

        onView(withId(R.id.ten_button_one)).perform(click())
        onView(withId(R.id.one_target_main)).check(matches(withText("62")))
        onView(withId(R.id.one_target_secondary)).check(matches(withText("1")))
    }

    @Test
    fun pressingButton4_displays0PointsAndNextTarget() {
        val scenario = launchFragmentInContainer<Catch40Fragment>(null, R.style.Theme_DartTrainer)

        onView(withId(R.id.ten_button_one)).perform(click())
        onView(withId(R.id.one_target_main)).check(matches(withText("62")))
        onView(withId(R.id.one_target_secondary)).check(matches(withText("0")))
    }
}