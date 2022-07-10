package com.example.dogapp.dogdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dogapp.databinding.ActivityDogDetailsBinding
import com.example.dogapp.interfaces.Dog

class DogDetailsActivity : AppCompatActivity() {
    companion object {
        const val DOG_KEY = "dog"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dog = intent?.extras?.getParcelable<Dog>(DOG_KEY)
        if(dog==null) {
            Toast.makeText(this, "Perro no encontrado", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        binding.dog = dog

    }
}