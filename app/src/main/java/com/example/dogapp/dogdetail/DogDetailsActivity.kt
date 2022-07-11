package com.example.dogapp.dogdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import coil.load
import com.example.dogapp.R
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
            Toast.makeText(this, R.string.messageError, Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        binding.dogIndex.text = getString(R.string.index_format, dog.index)
        binding.lifeExpectancy.text = getString(R.string.life_expectancy_format, dog.lifeExpectancy)
        binding.dog = dog
        binding.dogImage.load(dog.imageUrl)
        binding.closeButton.setOnClickListener {
            finish()
        }

    }
}