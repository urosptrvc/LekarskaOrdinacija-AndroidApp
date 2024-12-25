package com.example.lekarskaordinacija.Activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.lekarskaordinacija.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class IntroActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(IntroActivity::class.java)

    @Before
    fun setup() {
        Intents.init()
    }

    @Test
    fun testStartButtonNavigatesToLoginActivity() {
        onView(withId(R.id.startBtn)).perform(click())

        intended(hasComponent(LoginActivity::class.java.name))
    }

    @After
    fun tearDown() {
        Intents.release()
    }
}