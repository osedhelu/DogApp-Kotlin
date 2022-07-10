package com.example.dogapp.doglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogapp.databinding.ActivityDogListBinding

class DogListActivity : AppCompatActivity() {
    private val dogListViewMode:DogListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val rvDogList = binding.rvDogList
        rvDogList.layoutManager = LinearLayoutManager(this)
        val adapter = DogAdapter()
        rvDogList.adapter = adapter
        dogListViewMode.dogList.observe(this) {
                dogList ->
            adapter.submitList(dogList)
        }
    }
}