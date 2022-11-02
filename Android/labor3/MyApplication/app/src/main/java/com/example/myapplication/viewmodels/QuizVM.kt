package com.example.myapplication.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class QuizState(
     val MAX_QUESTIONS : Int = 5,
     val counter :Int = 1,
     val userName : String? = null,
     val result :Int = 0
)

class QuizVM : ViewModel() {

     private val _uiState = MutableStateFlow(QuizState())
     val uiState : StateFlow<QuizState> = _uiState.asStateFlow()

     fun isFinalQuestion() : Boolean{
          if (uiState.value.counter == uiState.value.MAX_QUESTIONS) {
               return true
          }
          return false
     }

     fun incrementCounter() {
          _uiState.update { currentState ->
               currentState.copy(
                    counter = currentState.counter+1
               )

          }
     }
     fun CounterToStart(){
          _uiState.update { currentState ->
               currentState.copy(
                    counter = 1
               )

          }
     }
     fun ResultToStart(){
          _uiState.update { currentState ->
               currentState.copy(
                    result = 0
               )

          }
     }

     fun setUserName(name:String){
          _uiState.update { currentState ->
               currentState.copy(
                    userName = name
               )
          }
     }
     fun CorrectAns(){
          _uiState.update { currentState ->
               currentState.copy(
                    result = currentState.result+1
               )

          }
     }
     fun getResult():Int?{
          return uiState.value.result
     }
     fun getMaxPoint():Int?{
          return uiState.value.MAX_QUESTIONS
     }

     fun getUserName(): String? {
          return uiState.value.userName
     }
     fun getQuestion():String?{
          when (uiState.value.counter){
               1 -> return "Melyik a legkisebb szam ? "
               2 -> return "Melyik a legnagyobb szam ?"
               3 -> return "Melyik a legkisebb primszam ?"
               4 -> return "Melyik primszam?"
               5 -> return "5+5/5-1=?"
          }
          return "Counter not found"
     }

     fun getAnswer1():String?{
          when (uiState.value.counter){
               1 -> return "1"
               2 -> return "2"
               3 -> return "3"
               4 -> return "4"
               5 -> return "5"
          }
          return "Counter not found"

     }

     fun getAnswer2():String?{
          when (uiState.value.counter){
               1 -> return "10"
               2 -> return "11"
               3 -> return "12"
               4 -> return "13"
               5 -> return "14"
          }
          return "Counter not found"

     }
     fun getAnswer3():String?{
          when (uiState.value.counter){
               1 -> return "21"
               2 -> return "22"
               3 -> return "23"
               4 -> return "24"
               5 -> return "26"
          }
          return "Counter not found"

     }
     fun getAnswer4():String?{
          when (uiState.value.counter){
               1 -> return "31"
               2 -> return "32"
               3 -> return "34"
               4 -> return "36"
               5 -> return "39"
          }
          return "Counter not found"

     }
     fun getCorrectAns(): Int?{
          when(uiState.value.counter){
               1 -> return 1
               2 -> return 4
               3 -> return 1
               4 -> return 2
               5 -> return 1
          }
          return null
     }

}