package com.example.lekarskaordinacija.Activity

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lekarskaordinacija.Adapter.CategoryAdapter
import com.example.lekarskaordinacija.Adapter.TopDoctorAdapter
import com.example.lekarskaordinacija.R
import com.example.lekarskaordinacija.ViewModel.MainViewModel
import com.example.lekarskaordinacija.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCategory()
        initTopDoctors()
        }

    private fun initTopDoctors() {
        binding.apply {
            progressBarTopDoctors.visibility=View.VISIBLE
            viewModel.doctors.observe(this@MainActivity, Observer {
                recyclerViewTopDoctor.layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
                recyclerViewTopDoctor.adapter=TopDoctorAdapter(it)
                progressBarTopDoctors.visibility=View.GONE
            })
            viewModel.loadDoctors()
        }
    }

    private fun initCategory() {
        binding.progressBarCategory.visibility = View.VISIBLE
        viewModel.category.observe(this, Observer {
            binding.viewCategory.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            binding.viewCategory.adapter = CategoryAdapter(it)
            binding.progressBarCategory.visibility=View.GONE
        })
        viewModel.loadCategory()
    }
}
