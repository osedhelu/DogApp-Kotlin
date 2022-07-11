package com.example.dogapp.api.dto

import com.example.dogapp.interfaces.User

class UserDtoMapper {
    private fun fromUserDTOtoUserDomain(userDTO: UserDTO): User {
        return User(
            id = userDTO.id,
           email = userDTO.email,
           authenticationToken = userDTO.authenticationToken
        )
    }
    fun convertFromUserDTOtoUser(user: UserDTO):User {
        return fromUserDTOtoUserDomain(user)
    }
}
