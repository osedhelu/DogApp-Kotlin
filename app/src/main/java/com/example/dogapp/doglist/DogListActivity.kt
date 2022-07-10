package com.example.dogapp.doglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dogapp.R
import com.example.dogapp.databinding.ActivityDogListBinding

class DogListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val modifier = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(modifier.root)
    }
}