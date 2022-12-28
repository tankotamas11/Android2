package com.example.a3track.viewmodels

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.a3track.MyApplication
import com.example.a3track.model.CurrentUser
import com.example.a3track.model.GetCUResponse
import com.example.a3track.model.LoginResponse
import com.example.a3track.model.User
import com.example.a3track.repository.TrackerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.Character.getName





class CurrentUserViewModel  : ViewModel(){
    private val _uiState = MutableLiveData(CurrentUser())
    //var usersList = MutableLiveData<List<User>>()


//    fun getusers(tokken:String){
//        viewModelScope.launch {
//        try {
//            val response = repository.getUsers(tokken)
//            if (response.isSuccessful) {
//               usersList.value = response.body()
//            } else {
//                Log.i("xxx-uvm", response.message())
//            }
//        } catch (e: java.lang.Exception) {
//            Log.i("xxx", e.toString())
//        }
//    }}
    fun getCurrentUser():Boolean{
        val token = _uiState.value?.loginResponse!!.token
        val userRepo = TrackerRepository()
    Log.i("ppp","na hajra2")
        var withoutException = true
        viewModelScope.launch {
            try {
                Log.i("ppp","na hajra")
                val response = userRepo.getCurrentUser(cuRequest = token)
                Log.i("ppp","itt is jarhatunk ha jo")
                if(response.isSuccessful){
                    val responses = response.body().toString().trim().split(",")
                    val responsesToUse : MutableList<String> = mutableListOf()
                    for(r in responses){
                        val temp = r.split("=")[1]
                        responsesToUse.add(temp)
                    }
                    for(r in responsesToUse){
                        Log.i("CurrentUser", r)
                    }
                    updateUserId(responsesToUse[0].toInt())
                    updateName(responsesToUse[2],responsesToUse[1])
                    updateEmail(responsesToUse[3])
                    updateType(responsesToUse[4].toInt())
                    updateLocation(responsesToUse[5])
                    updatePhoneNumber(responsesToUse[6])
                    updateDepartmentId(responsesToUse[7].toInt())
                    updateImage(responsesToUse[8].dropLast(1))
                    updateLoginResponse(getDeadline(),getToken(),responsesToUse[0].toInt())
                    Log.i("CurrentUser",getName())
                }
            } catch (ex: Exception){
                Log.i("CU VM Exception",ex.message,ex)
                withoutException = false
            }
        }
        return withoutException
    }

     fun getToken(): String {
    return _uiState.value!!.loginResponse.token
    }
 fun getDeadline(): Long {
        return  _uiState.value!!.loginResponse.deadline
    }
    fun getId(): Int {
        return  _uiState.value!!.loginResponse.userId
    }


    fun updateLoginResponse(deadline1: Long, token1: String, id1: Int) {
    _uiState.value!!.loginResponse = LoginResponse(id1,token1,deadline1)

    }

    private fun updateImage(newimg: String) {
    _uiState.value!!.imageUrl = newimg
    }

    private fun updateDepartmentId(newdep: Int) {
        _uiState.value!!.department_id = newdep
    }

    private fun updateLocation(newloc: String) {
    _uiState.value!!.location = newloc
    }

    private fun updatePhoneNumber(newNum: String) {
    _uiState.value!!.phone_number = newNum
    }

    private fun updateType(newtype: Int) {
    _uiState.value!!.type = newtype

    }

    private fun updateEmail(email1: String) {
    _uiState.value!!.email = email1

    }

    private fun updateName(first: String, last: String) {
        _uiState.value!!.last_name = last ;
        _uiState.value!!.first_name = first

    }

    fun updateUserId(newId : Int){
        _uiState.value!!.ID = newId


    }


    fun getName():String{
        return _uiState.value!!.first_name + _uiState.value!!.last_name
    }

}