package com.example.dogapp.auth

import com.example.dogapp.api.ApiResponseStatus
import com.example.dogapp.api.DogsApi
import com.example.dogapp.api.dto.DogDtoMapper
import com.example.dogapp.api.dto.SignUpDTO
import com.example.dogapp.api.dto.UserDtoMapper
import com.example.dogapp.api.makeNetworkCall
import com.example.dogapp.interfaces.User

class AuthRepository {
    suspend fun signup(email: String, pass:String, passConfirmation:String): ApiResponseStatus<User> = makeNetworkCall {
        val signUpdto = SignUpDTO(email,pass,passConfirmation)
        val signupResponse = DogsApi.retrofitService.signUp(signUpdto)
       if(!signupResponse.isSuccess) {
           throw Exception(signupResponse.message)
       }
        val userDTO = signupResponse.data.user
        val userDtoMapper = UserDtoMapper()
        userDtoMapper.convertFromUserDTOtoUser(userDTO)
    }
}