package com.example.lekarskaordinacija.Activity

import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowToast
import android.widget.TextView
import com.example.lekarskaordinacija.R

@RunWith(RobolectricTestRunner::class)
@Config(
    sdk = [30],
    manifest = Config.NONE  // Add this to remove the manifest warning
)
class LoginActivityTest {

    @Mock
    private lateinit var mockFirebaseAuth: FirebaseAuth

    @Mock
    private lateinit var mockAuthTask: Task<AuthResult>

    @Mock
    private lateinit var mockFirebaseUser: FirebaseUser

    private lateinit var loginActivity: LoginActivity

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        // Create the activity
        loginActivity = Robolectric.buildActivity(LoginActivity::class.java).create().get()

        // Replace the Firebase Auth instance with mock
        loginActivity.auth = mockFirebaseAuth
    }

    @Test
    fun `login with empty email shows toast`() {
        // Set up email field as empty
        val emailField = loginActivity.findViewById<TextView>(R.id.emailEditText)
        emailField.text = ""

        // Click login button
        loginActivity.findViewById<TextView>(R.id.startBtn).performClick()

        // Verify toast is shown
        val latestToast = ShadowToast.getLatestToast()
        assert(latestToast != null) { "Toast should be shown" }
        assert(ShadowToast.getTextOfLatestToast() == "Niste uneli email") {
            "Toast text does not match expected"
        }
    }

    @Test
    fun `login with empty password shows toast`() {
        // Set up email field with some value
        val emailField = loginActivity.findViewById<TextView>(R.id.emailEditText)
        val passwordField = loginActivity.findViewById<TextView>(R.id.passwordEditText)

        emailField.text = "test@example.com"
        passwordField.text = ""

        // Click login button
        loginActivity.findViewById<TextView>(R.id.startBtn).performClick()

        // Verify toast is shown
        val latestToast = ShadowToast.getLatestToast()
        assert(latestToast != null) { "Toast should be shown" }
        assert(ShadowToast.getTextOfLatestToast() == "Niste uneli sifru") {
            "Toast text does not match expected"
        }
    }

    @Test
    fun `successful login navigates to MainActivity`() {
        // Prepare mock Firebase authentication
        `when`(mockFirebaseAuth.signInWithEmailAndPassword(anyString(), anyString()))
            .thenReturn(mockAuthTask)

        // Mock successful authentication
        `when`(mockAuthTask.isSuccessful).thenReturn(true)
        `when`(mockAuthTask.addOnCompleteListener(any())).thenAnswer { invocation ->
            val listener = invocation.arguments[0] as (Task<AuthResult>) -> Unit
            listener.invoke(mockAuthTask)
            mockAuthTask
        }
        `when`(mockFirebaseAuth.currentUser).thenReturn(mockFirebaseUser)

        // Set up login credentials
        val emailField = loginActivity.findViewById<TextView>(R.id.emailEditText)
        val passwordField = loginActivity.findViewById<TextView>(R.id.passwordEditText)

        emailField.text = "test@example.com"
        passwordField.text = "password123"

        // Click login button
        loginActivity.findViewById<TextView>(R.id.startBtn).performClick()

        // Verify navigation to MainActivity
        val shadowActivity = Shadows.shadowOf(loginActivity)
        val startedIntent = shadowActivity.nextStartedActivity
        assert(startedIntent.component?.className == MainActivity::class.java.name) {
            "Should navigate to MainActivity"
        }
    }

    @Test
    fun `failed login shows authentication failure toast`() {
        // Prepare mock Firebase authentication
        `when`(mockFirebaseAuth.signInWithEmailAndPassword(anyString(), anyString()))
            .thenReturn(mockAuthTask)

        // Mock failed authentication
        `when`(mockAuthTask.isSuccessful).thenReturn(false)
        `when`(mockAuthTask.addOnCompleteListener(any())).thenAnswer { invocation ->
            val listener = invocation.arguments[0] as (Task<AuthResult>) -> Unit
            listener.invoke(mockAuthTask)
            mockAuthTask
        }

        // Set up login credentials
        val emailField = loginActivity.findViewById<TextView>(R.id.emailEditText)
        val passwordField = loginActivity.findViewById<TextView>(R.id.passwordEditText)

        emailField.text = "test@example.com"
        passwordField.text = "wrongpassword"

        // Click login button
        loginActivity.findViewById<TextView>(R.id.startBtn).performClick()

        // Verify authentication failure toast
        val latestToast = ShadowToast.getLatestToast()
        assert(latestToast != null) { "Toast should be shown" }
        assert(ShadowToast.getTextOfLatestToast() == "Authentication failed.") {
            "Toast text does not match expected"
        }
    }

    @Test
    fun `clicking register now navigates to RegisterActivity`() {
        // Click register now text view
        val registerTextView = loginActivity.findViewById<TextView>(R.id.registerTextView)
        registerTextView.performClick()

        // Verify navigation to RegisterActivity
        val shadowActivity = Shadows.shadowOf(loginActivity)
        val startedIntent = shadowActivity.nextStartedActivity
        assert(startedIntent.component?.className == RegisterActivity::class.java.name) {
            "Should navigate to RegisterActivity"
        }
    }
}