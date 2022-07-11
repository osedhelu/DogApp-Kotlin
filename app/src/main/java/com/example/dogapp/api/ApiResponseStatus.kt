package com.example.dogapp.api
sealed class ApiResponseStatus<T>() {
    class Loading<T>() : ApiResponseStatus<T>()
    class Error<T>(val messageId: Int) : ApiResponseStatus<T>()
    class Success<T>(val data: T) : ApiResponseStatus<T>()
}