package com.example.a3track.repository

import com.example.a3track.api.RetrofitInstance
import com.example.a3track.api.TrackerApi
import com.example.a3track.model.*
import retrofit2.Response


class TrackerRepository {
    suspend fun login(request: LoginRequest): Response<LoginResponse> {
        return RetrofitInstance.api.login(request)
    }
    suspend fun updateProfile(token:String,request: ProfileRequest): Response<LoginResponse>{
        return  RetrofitInstance.api.updateProfile(token,request)
    }

    suspend fun getUsers(token: String): Response<List<User>> {
        return RetrofitInstance.api.getUsers(token)
    }
    suspend fun getTasks(token: String):Response<List<TasksResponse>>{
        return TrackerApi.getApi()!!.getTasks(token)
    }
    suspend fun getCurrentUser(cuRequest: String): Response<GetCUResponse> {
        return TrackerApi.getApi()!!.getCurrentUser(token = cuRequest)
    }
    suspend fun getDepartments(token: String):Response<List<Departments>>{
        return TrackerApi.getApi()!!.getDepartments(token)
    }
}