package com.example.lekarskaordinacija.Activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.lekarskaordinacija.R
import com.google.firebase.auth.FirebaseAuth
import junit.framework.TestCase.assertEquals
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Before
    fun setup() {
        Intents.init()

        FirebaseAuth.getInstance().signOut()
    }

    @Test
    fun testRegisterTextViewNavigatesToRegisterActivity() {
        onView(withId(R.id.registerTextView)).perform(click())

        intended(hasComponent(RegisterActivity::class.java.name))
    }

    @Test
    fun testValidLoginShowsAuth() {
        onView(withId(R.id.emailEditText)).perform(typeText("partizan.uros@gmail.com"))
        onView(withId(R.id.passwordEditText)).perform(typeText("Gtacoa201"))

        onView(withId(R.id.startBtn)).perform(click())


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