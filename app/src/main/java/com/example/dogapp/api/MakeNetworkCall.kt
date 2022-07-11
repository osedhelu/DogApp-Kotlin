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
            ApiResponseStatus.Error(R.string.unknown_error)
        }

    }

}