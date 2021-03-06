package com.example.dogapp.doglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogapp.GRID_SPAN_COUNT
import com.example.dogapp.api.ApiResponseStatus
import com.example.dogapp.databinding.ActivityDogListBinding
import com.example.dogapp.dogdetail.DogDetailsActivity
import com.example.dogapp.dogdetail.DogDetailsActivity.Companion.DOG_KEY

class DogListActivity : AppCompatActivity() {
    private val dogListViewMode: DogListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val rvDogList = binding.rvDogList
        rvDogList.layoutManager = GridLayoutManager(this, GRID_SPAN_COUNT)
        val adapter = DogAdapter()
        val pbLoadigDog = binding.pbLoadigDog
        adapter.setOnItemClickListener {
            val intent = Intent(this, DogDetailsActivity::class.java)
            intent.putExtra(DOG_KEY, it)
            println(intent)
            startActivity(intent)

        }
        rvDogList.adapter = adapter
        dogListViewMode.dogList.observe(this) { dogList ->
            adapter.submitList(dogList)
        }

        dogListViewMode.status.observe(this) { status ->
            when (status) {
               is ApiResponseStatus.Error -> {
                    pbLoadigDog.visibility = View.GONE
                    Toast.makeText(
                        this,
                        status.messageId,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is ApiResponseStatus.Loading -> pbLoadigDog.visibility = View.VISIBLE
                is ApiResponseStatus.Success -> pbLoadigDog.visibility = View.GONE
            }
        }
    }
}
