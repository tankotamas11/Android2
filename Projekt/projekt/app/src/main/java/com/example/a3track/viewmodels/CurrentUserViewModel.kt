package com.example.a3track.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a3track.model.CurrentUser
import com.example.a3track.model.LoginResponse
import com.example.a3track.repository.TrackerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.lang.Character.getName



class CurrentUserViewModel (val repository: TrackerRepository) : ViewModel(){
    private val _uiState = MutableStateFlow(CurrentUser())
    fun getCurrentUser():Boolean{

        val token = _uiState.value.loginResponse.token
        val userRepo = TrackerRepository()
        var withoutException = true
        viewModelScope.launch {
            try {
                val response = userRepo.getCurrentUser(cuRequest = token)
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

    private fun getToken(): String {
    return _uiState.value.loginResponse.token
    }

    private fun getDeadline(): Long {
        return  _uiState.value.loginResponse.deadline
    }


    private fun updateLoginResponse(deadline1: Long, token1: String, id1: Int) {
    _uiState.update { currentState -> currentState.copy(
        loginResponse = LoginResponse(id1,token1,deadline1)
    ) }
    }

    private fun updateImage(newimg: String) {
    _uiState.update { currentState -> currentState.copy(imageUrl = newimg) }
    }

    private fun updateDepartmentId(newdep: Int) {
        _uiState.update { currentState ->  currentState.copy(department_id = newdep) }
    }

    private fun updateLocation(newloc: String) {
    _uiState.update { currentState -> currentState.copy(location = newloc) }
    }

    private fun updatePhoneNumber(newNum: String) {
    _uiState.update { currentState -> currentState.copy(phone_number = newNum) }
    }

    private fun updateType(newtype: Int) {
    _uiState.update { currentState ->  currentState.copy(
    type = newtype
) }
    }

    private fun updateEmail(email1: String) {
    _uiState.update { currentState -> currentState.copy(
        email = email1
    ) }
    }

    private fun updateName(first: String, last: String) {
        _uiState.update {  currentState -> currentState.copy(
            last_name = last ,
            first_name = first
        )  }
    }

    fun updateUserId(newId : Int){
        _uiState.update { currentState ->
            currentState.copy(
                ID = newId
            )
        }
    }


    fun getName():String{
        return _uiState.value.first_name + _uiState.value.last_name
    }

}