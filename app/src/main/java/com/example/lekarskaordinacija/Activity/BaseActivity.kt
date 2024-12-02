package com.example.lekarskaordinacija.Activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.lekarskaordinacija.databinding.ActivityBaseBinding

open class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)  // Inflate binding objekta
        setContentView(binding.root)

        // Postavi prozor za full-screen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        // Postavi klik događaje za navigaciju
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        // Koristi binding za pristup elementima
        binding.homeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0) // Bez animacije
        }

        binding.settingsBtn.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0) // Bez animacije
        }

        binding.accountBtn.setOnClickListener {
            val intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0) // Bez animacije
        }
    }
}
