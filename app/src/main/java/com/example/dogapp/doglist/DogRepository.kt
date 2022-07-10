package com.example.dogapp.doglist

import com.example.dogapp.api.DogsApi.retrofitService
import com.example.dogapp.api.dto.DogDtoMapper
import com.example.dogapp.interfaces.Dog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {
    suspend fun downloadDogs(): List<Dog> {
        return withContext(Dispatchers.IO) {
            val dogListApiResponse =  retrofitService.getAllDogs()
//            val dogDtoList= dogListApiResponse.data.dogs
            dogListApiResponse.data.dogs
//            val dogDtoMapper = DogDtoMapper()
//            dogDtoMapper.fromDogDTOListToDogDomainList(dogDtoList)
        }

    }
}