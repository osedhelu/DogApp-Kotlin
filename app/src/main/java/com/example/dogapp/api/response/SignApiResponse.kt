package com.example.dogapp.api.response

import com.squareup.moshi.Json

class SignApiResponse (
        val message: String,
        @field:Json(name = "is_success") val isSuccess: Boolean,
        val data: UserResponse
    )