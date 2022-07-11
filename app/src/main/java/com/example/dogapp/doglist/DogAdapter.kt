package com.example.dogapp.doglist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dogapp.databinding.DogListItemBinding
import com.example.dogapp.interfaces.Dog

class DogAdapter: ListAdapter<Dog,DogAdapter.DogViewHolder>(DiffCallback) {
    companion object DiffCallback: DiffUtil.ItemCallback<Dog>() {
        override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem.id === newItem.id
        }
    }

    private var onItemClickListener:((Dog)->Unit)? = null
    fun setOnItemClickListener (onItemClickListener:(Dog)->Unit) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int ):DogViewHolder {
        val binding = DogListItemBinding
            .inflate(LayoutInflater.from(parent.context))
         return DogViewHolder(binding)

    }
    override fun onBindViewHolder(dogViewHolder: DogViewHolder,position: Int) {

        val dog = getItem(position)
        dogViewHolder.bind(dog)
    }
    inner class DogViewHolder(private val binding: DogListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (dog: Dog) {
            binding.dogListItemLayout.setOnClickListener {
                onItemClickListener?.invoke(dog)
            }
            binding.ivDogImg.load(dog.imageUrl)
            binding.tvNameDog.text = dog.name
        }

    }
}