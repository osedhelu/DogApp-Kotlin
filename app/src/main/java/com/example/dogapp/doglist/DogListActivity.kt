package com.example.dogapp.doglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogapp.databinding.ActivityDogListBinding
import com.example.dogapp.dogdetail.DogDetailsActivity
import com.example.dogapp.dogdetail.DogDetailsActivity.Companion.DOG_KEY

class DogListActivity : AppCompatActivity() {
    private val dogListViewMode:DogListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val rvDogList = binding.rvDogList
        rvDogList.layoutManager = LinearLayoutManager(this)
        val adapter = DogAdapter()
        adapter.setOnItemClickListener {
            val intent = Intent(this,DogDetailsActivity::class.java)
            intent.putExtra(DOG_KEY, it)
            println(intent)

//            intent.putExtra(DOG_KEY,it)
            startActivity(intent)

        }
        rvDogList.adapter = adapter
        dogListViewMode.dogList.observe(this) {
                dogList ->
            adapter.submitList(dogList)
        }
    }
}