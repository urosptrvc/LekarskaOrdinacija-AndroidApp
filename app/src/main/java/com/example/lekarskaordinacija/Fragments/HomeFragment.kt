package com.example.lekarskaordinacija.Fragment

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lekarskaordinacija.Activity.AccountActivity
import com.example.lekarskaordinacija.Activity.MainActivity
import com.example.lekarskaordinacija.Activity.SettingsActivity
import com.example.lekarskaordinacija.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Povezivanje dugmadi sa akcijama
        binding.homeBtn.setOnClickListener {
            // Otvori aktivnost za kategorije
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }

        binding.settingsBtn.setOnClickListener {
            // Otvori aktivnost za top doktore
            val intent = Intent(activity, SettingsActivity::class.java)
            startActivity(intent)
        }

        binding.accountBtn.setOnClickListener {
            // Otvori aktivnost za korisnički nalog
            val intent = Intent(activity, AccountActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

