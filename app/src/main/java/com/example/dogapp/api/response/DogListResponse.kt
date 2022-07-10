package com.example.dogapp.api.response

import com.example.dogapp.api.dto.DogDTO
import com.example.dogapp.interfaces.Dog
import com.squareup.moshi.Json

class DogListResponse  (val dogs: List<Dog>)