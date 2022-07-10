package com.example.dogapp.dogdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dogapp.databinding.ActivityDogDetailsBinding

class DogDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val modifier = ActivityDogDetailsBinding.inflate(layoutInflater)
        setContentView(modifier.root)
    }
}