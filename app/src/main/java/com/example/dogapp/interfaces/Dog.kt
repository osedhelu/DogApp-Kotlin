package com.example.dogapp.interfaces

import com.squareup.moshi.Json

data class Dog(
    val id: Long,
    val index: Int,
    @field:Json(name = "name_es") val name: String,
    val type: String,
    val heightFemale: String,
    val heightMale: String,
    val imageUrl: String,
    val lifeExpectancy: String,
    val temperament: String,
    val weightFemale: String,
    val weightMale: String
)
