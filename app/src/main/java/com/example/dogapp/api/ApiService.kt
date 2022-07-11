package com.example.dogapp.api


import com.example.dogapp.BASE_URL
import com.example.dogapp.GET_ALL_DOGS_URL
import com.example.dogapp.SIGN_UP_URL
import com.example.dogapp.api.dto.SignUpDTO
import com.example.dogapp.api.response.DogListApiResponse
import com.example.dogapp.api.response.SignApiResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()


interface ApiServer {
    @GET(GET_ALL_DOGS_URL)
    suspend fun getAllDogs(): DogListApiResponse
    @POST(SIGN_UP_URL)
    suspend fun signUp(@Body signUpDTO: SignUpDTO): SignApiResponse
}
object DogsApi {
    val retrofitService: ApiServer by lazy {
        retrofit.create(ApiServer::class.java)
    }
}