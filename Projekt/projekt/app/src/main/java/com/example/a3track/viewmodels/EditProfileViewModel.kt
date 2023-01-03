package com.example.a3track.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.a3track.model.LoginRequest
import com.example.a3track.model.LoginResult
import com.example.a3track.model.ProfileRequest
import com.example.a3track.model.UpdateResult
import com.example.a3track.repository.TrackerRepository
import kotlinx.coroutines.launch





class EditProfileViewModel() : ViewModel() {


    var updateResult: MutableLiveData<UpdateResult> = MutableLiveData()
    private var responseToSendBack : List<String>? = null
    fun update(token:String,request: ProfileRequest) {
        viewModelScope.launch {
            try {
                val repository= TrackerRepository()
                val response = repository.updateProfile(token,request)
                if (response?.isSuccessful==true) {
                    Log.i("PPP","Sikeres update")
                }
            } catch (e: Exception) {
                updateResult.value = UpdateResult.UNKNOWN_ERROR
                Log.i("xxx", e.toString())
            }
        }
    }
    fun getResponse(): List<String> {
        return responseToSendBack ?: emptyList()
    }
}