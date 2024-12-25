package com.example.lekarskaordinacija.Activity

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.lekarskaordinacija.R
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @Test
    fun StartsTopDoctorsActivity() {

            onView(withId(R.id.doctorListTxt)).perform(click())

            Intents.intended(IntentMatchers.hasComponent(TopDoctorsActivity::class.java.name))

    }

    @Test
    fun backTopDoctorsActivity(){

        onView(withId(R.id.doctorListTxt)).perform(click())

        onView(withId(R.id.backBtn)).perform(click())

        activityRule.scenario.onActivity { activity ->
            val currentActivity = MainActivity::class.java.simpleName
            assertEquals(currentActivity,"MainActivity")
        }

    }

    @After
    fun tearDown() {
        Intents.release()
    }

}
