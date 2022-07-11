package com.example.dogapp.doglist

import com.example.dogapp.api.ApiResponseStatus
import com.example.dogapp.api.DogsApi.retrofitService
import com.example.dogapp.api.dto.DogDtoMapper
import com.example.dogapp.api.makeNetworkCall
import com.example.dogapp.interfaces.Dog

class DogRepository {
    suspend fun downloadDogs(): ApiResponseStatus<List<Dog>> = makeNetworkCall {
        val dogListApiResponse = retrofitService.getAllDogs()
        val dogDTOList = dogListApiResponse.data.dogs
        val dogDtoMapper = DogDtoMapper()
        dogDtoMapper.fromDogDTOListToDogDomainList(dogDTOList)
    }
}
