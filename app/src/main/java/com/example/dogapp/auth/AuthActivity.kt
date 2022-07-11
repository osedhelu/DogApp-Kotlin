package com.example.dogapp.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dogapp.R
import com.example.dogapp.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}