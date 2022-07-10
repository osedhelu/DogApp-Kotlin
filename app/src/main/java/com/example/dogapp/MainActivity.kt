package com.example.dogapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dogapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val modifier = ActivityMainBinding.inflate(layoutInflater)
        setContentView(modifier.root)
    }
}