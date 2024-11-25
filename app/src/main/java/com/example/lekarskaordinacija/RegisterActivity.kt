package com.example.lekarskaordinacija

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

class RegisterActivity : AppCompatActivity() {
    lateinit var email: TextView
    lateinit var password: TextView
    lateinit var name: TextView
    lateinit var registerBtn: Button
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)



        email = findViewById(R.id.emailEditText)
        password = findViewById(R.id.passwordEditText)
        name = findViewById(R.id.nameEditText)
        registerBtn = findViewById(R.id.registerBtn)

        registerBtn.setOnClickListener {
            var email = email.text.toString()
            var password = password.text.toString()
            var name = name.text.toString()
            auth = FirebaseAuth.getInstance()

            if (email == null) {
                Toast.makeText(this@RegisterActivity, "Niste uneli email", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            if (password == null) {
                Toast.makeText(this@RegisterActivity, "Niste uneli sifru", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
                        val intent = Intent(applicationContext, LoginActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
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