package com.example.a3track.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.a3track.model.TasksResponse
import com.example.a3track.model.User
import com.example.a3track.repository.TrackerRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class TasksViewModelFactory(private val repository: TrackerRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TasksViewModel(repository) as T
    }
}

class TasksViewModel(val repository: TrackerRepository):ViewModel() {
    var taskList = MutableLiveData<List<TasksResponse>>()

    fun readTasks(token:String) {
        viewModelScope.launch {
            try {
                Log.i("TTT","respones meghatarozasa elott")
                val response = repository.getTasks(token)
                Log.i("TTT","respones meghatarozasa utan token:" + token)
                if (response.isSuccessful) {
                    taskList.value = response.body()
                } else {
                    Log.i("xxx1-uvm", response.message())
                }
            } catch (e: Exception) {
                Log.i("xxx", e.toString())
            }
        }

    }

}


