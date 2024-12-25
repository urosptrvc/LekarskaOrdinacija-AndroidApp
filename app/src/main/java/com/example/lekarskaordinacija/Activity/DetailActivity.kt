package com.example.lekarskaordinacija.Activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.lekarskaordinacija.Domain.DoctorsModel
import com.example.lekarskaordinacija.R
import com.example.lekarskaordinacija.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity() {
    lateinit var binding:ActivityDetailBinding
    private lateinit var item:DoctorsModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBundle()
    }


    fun getBundle(){
        item = intent.getParcelableExtra("object") !!



        binding.apply {
            titleTxt.text=item.Name
            specialTxt.text=item.Special
            bioTxt.text=item.Biography

            backBtn.setOnClickListener{ finish()}


            Glide.with(this@DetailActivity)
                .load(item.Picture)
                .into(img)

        }
    }
}