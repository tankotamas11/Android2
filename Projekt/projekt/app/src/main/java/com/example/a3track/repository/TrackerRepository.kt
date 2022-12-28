package com.example.a3track.repository

import com.example.a3track.api.RetrofitInstance
import com.example.a3track.api.TrackerApi
import com.example.a3track.model.GetCUResponse
import retrofit2.Response
import com.example.a3track.model.User
import com.example.a3track.model.LoginResponse
import com.example.a3track.model.LoginRequest


class TrackerRepository {
    suspend fun login(request: LoginRequest): Response<LoginResponse> {
        return RetrofitInstance.api.login(request)
    }

    suspend fun getUsers(token: String): Response<List<User>> {
        return RetrofitInstance.api.getUsers(token)
    }
    suspend fun getCurrentUser(cuRequest: String): Response<GetCUResponse> {
        return TrackerApi.getApi()!!.getCurrentUser(token = cuRequest)
    }
}