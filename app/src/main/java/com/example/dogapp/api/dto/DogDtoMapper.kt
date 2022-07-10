package com.example.dogapp.api.dto

import com.example.dogapp.interfaces.Dog

class DogDtoMapper {
    private fun fromDogDTOtoDogDomain(dogDTO: DogDTO): Dog {
        return Dog(
            id = dogDTO.id,
            index = dogDTO.index,
            name = dogDTO.name,
            type = dogDTO.type,
            heightFemale = dogDTO.heightFemale,
            heightMale = dogDTO.heightMale,
            imageUrl = dogDTO.imageUrl,
            lifeExpectancy = dogDTO.lifeExpectancy,
            temperament = dogDTO.temperament,
            weightFemale = dogDTO.weightFemale,
            weightMale = dogDTO.weightMale,
        )
    }
    fun fromDogDTOListToDogDomainList(dogDtoList: List<DogDTO>): List<Dog> {
        return dogDtoList.map { fromDogDTOtoDogDomain(it)}

    }
}