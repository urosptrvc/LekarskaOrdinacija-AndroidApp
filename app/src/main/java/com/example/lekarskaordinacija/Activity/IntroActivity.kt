package com.example.lekarskaordinacija.Activity

import android.content.Intent
import android.os.Bundle
import com.example.lekarskaordinacija.databinding.ActivityIntroBinding

class IntroActivity : BaseActivity() {
    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener {
            startActivity(Intent(this@IntroActivity, LoginActivity::class.java))
        }
    }
}
