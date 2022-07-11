package com.example.dogapp.api

import com.example.dogapp.R
import com.example.dogapp.api.dto.DogDtoMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> makeNetworkCall(
    call: suspend () -> T
):ApiResponseStatus<T> {
    return withContext(Dispatchers.IO) {
        try {
            ApiResponseStatus.Success(call())
        }catch (e:Exception) {
            ApiResponseStatus.Error(R.string.unknown_host_exception_error)
        }catch (e:Exception) {
           val errorMessage = when(e.message) {
                "sign_up_error" -> R.string.error_sign_up
                "sign_in_error" -> R.string.error_sign_in
                "user_already_exists" -> R.string.user_already_exists
                else -> R.string.unknown_error
            }
            ApiResponseStatus.Error(errorMessage)
        }

    }

}