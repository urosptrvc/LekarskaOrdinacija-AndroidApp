package com.example.lekarskaordinacija

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var email: TextView
    lateinit var password: TextView
    lateinit var name: TextView
    lateinit var registerNow: TextView
    lateinit var loginBtn: Button
    lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.emailEditText)
        password = findViewById(R.id.passwordEditText)
        loginBtn = findViewById(R.id.startBtn)
        registerNow = findViewById(R.id.registerTextView)
        auth = FirebaseAuth.getInstance()


        registerNow.setOnClickListener{
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        loginBtn.setOnClickListener {
            var email = email.text
            var password = password.text

            if (email == null) {
                Toast.makeText(this@LoginActivity, "Niste uneli email", Toast.LENGTH_SHORT).show()
            }
            if (password == null) {
                Toast.makeText(this@LoginActivity, "Niste uneli sifru", Toast.LENGTH_SHORT).show()
            }

            auth.signInWithEmailAndPassword(email.toString(), password.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        val user = auth.currentUser
                        val intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }




        }
    }
}