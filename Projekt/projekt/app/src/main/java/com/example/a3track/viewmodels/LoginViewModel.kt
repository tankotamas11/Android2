package com.example.a3track.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.a3track.model.LoginRequest
import com.example.a3track.MyApplication
import com.example.a3track.model.LoginResult
import com.example.a3track.repository.TrackerRepository

class LoginViewModelFactory(
    private val repository: TrackerRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(repository) as T
    }
}

class LoginViewModel(val repository: TrackerRepository) : ViewModel() {

    var loginResult: MutableLiveData<LoginResult> = MutableLiveData()
    private var responseToSendBack : List<String>? = null
    fun login(request: LoginRequest) {
        viewModelScope.launch {
            try {
                val response = repository.login(request)
                if (response.isSuccessful) {

                    val responses =  response.body().toString().trim().split(",")
                    val responses0 = responses[0].split("=")
                    val responses1 = responses[1].split("=")
                    var responses2 = responses[2].split("=")
                    responses2 = responses2[1].split(")")
                    Log.d("TAG","Responses0[1] = ${responses0[1]}")
                    Log.d("TAG","Responses1[1] = ${responses1[1]}")
                    Log.d("TAG","Responses2[1] = ${responses2[0]}")
                    responseToSendBack = listOf(responses0[1],responses1[1],responses2[0])

                    Log.i("xxx", response.body().toString())
                    loginResult.value = LoginResult.SUCCESS
                } else {
                    loginResult.value = LoginResult.INVALID_CREDENTIALS
                    Log.i("xxx1", "Invalid credentials " + response.errorBody().toString()  )
                }
            } catch (e: Exception) {
                loginResult.value = LoginResult.UNKNOWN_ERROR
                Log.i("xxx", e.toString())
            }
        }
    }
    fun getResponse(): List<String> {
        return responseToSendBack ?: emptyList()
    }
}