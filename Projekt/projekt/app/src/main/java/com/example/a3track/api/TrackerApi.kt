package com.example.a3track.api

import com.example.a3track.model.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import com.example.a3track.util.Constants


interface TrackerApi {
    @POST(Constants.LOGIN_URL)
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET(Constants.GET_USERS_URL)
    suspend fun getUsers(@Header("token") token: String): Response<List<User>>
    @GET("/task")
    suspend fun getTasks(@Header("token")token: String):Response<List<TasksResponse>>
    @GET("/user")
    suspend fun getCurrentUser(@Header("token") token: String): Response<GetCUResponse>
    companion object {
        fun getApi(): TrackerApi? {
            return RetrofitInstance.client?.create(TrackerApi::class.java)
        }
    }
}