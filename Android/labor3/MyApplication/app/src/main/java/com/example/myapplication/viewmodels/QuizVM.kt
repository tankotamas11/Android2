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

//data class Item(
//     val question : String,
//     val answers : List<String>,
//     val correct : Int
//     )

data class Tasks(
     var questions: Array<String?> = arrayOf("What is the difference between val and var in Kotlin?", "What does a data class not offer?", "Which of these targets does Kotlin currently not support?" , "What are Kotlin coroutines?","What is the correct way to declare a variable of integer type in Kotlin?"),
     var answers: Array<String?> = arrayOf("Variables declared with var are final, those with val are not. Haliho" , "Variables declared with val are final, those with var are not.","var is scoped to the nearest function block and val is scoped to the nearest enclosing block.", "Variables declared with val can only access const members.","An auto-generated toString() method.","Auto-generated hashcode() and equals() methods.","Automatic conversion from/to JSON.","A generated copy method, to create copies of instances.","JVM","LLVM", ".NET CLR","JavaScript","They provide asynchronous code without thread blocking.","It's Kotlin's term for class methods.","These are functions which accept other functions as arguments or return them.","That's how the automatically generated methods hashCode() and equals() in data classes are called.","int i = 42","let i = 42","var i : int = 42","var i : Int = 42"),
     var correctanswers: Array<Int?> = arrayOf(2,3,3,1,4),

     // var t:Array<String?> = arrayOfNulls(10)
)


class QuizVM : ViewModel() {

     private val _uiState = MutableStateFlow(QuizState())
     val uiState : StateFlow<QuizState> = _uiState.asStateFlow()

     private val _uiState1 = MutableStateFlow(Tasks())
     val uiState1 : StateFlow<Tasks> = _uiState1.asStateFlow()

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
     fun newQuestion(quest:String){
          _uiState1.update { currentState -> currentState.copy(
               questions = appendQuestion(quest)
          ) }
     }
     fun  appendQuestion( element: String): Array<String?> {
          val array = uiState1.value.questions.copyOf(uiState1.value.questions.size + 1)
          array[uiState1.value.questions.size] = element
          return array
     }
     fun newAnswer(quest:String){
          _uiState1.update { currentState -> currentState.copy(
               answers = appendAnswer(quest)
          ) }
     }
     fun  appendAnswer( element: String): Array<String?> {
          val array = uiState1.value.answers.copyOf(uiState1.value.answers.size + 1)
          array[uiState1.value.answers.size] = element
          return array
     }
     fun newCorrectAnswer(answ:Int){
          _uiState1.update { currentState -> currentState.copy(
               correctanswers = appendCorrectAnswer(answ)
          ) }
     }
     fun  appendCorrectAnswer( element: Int): Array<Int?> {
          val array = uiState1.value.correctanswers.copyOf(uiState1.value.correctanswers.size + 1)
          array[uiState1.value.correctanswers.size] = element
          return array
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
               1 -> return uiState1.value.questions[0]
               2 -> return uiState1.value.questions[1]
               3 -> return uiState1.value.questions[2]
               4 -> return uiState1.value.questions[3]
               5 -> return uiState1.value.questions[4]
          }
          return "Counter not found"
     }

     fun getAnswer(poz:Int):String?{
         // when (uiState.value.counter){
             return uiState1.value.answers[(uiState.value.counter-1)*4+poz-1]
//               2 -> return uiState1.value.answers[(uiState.value.counter-1)*4+poz-1]
//               3 -> return uiState1.value.answers[(uiState.value.counter-1)*4+poz-1]
//               4 -> return "4"
//               5 -> return "5"
//          }
//          return "Counter not found"

     }

//     fun getAnswer2():String?{
//          when (uiState.value.counter){
//               1 -> return "10"
//               2 -> return "11"
//               3 -> return "12"
//               4 -> return "13"
//               5 -> return "14"
//          }
//          return "Counter not found"
//
//     }
//     fun getAnswer3():String?{
//          when (uiState.value.counter){
//               1 -> return "21"
//               2 -> return "22"
//               3 -> return "23"
//               4 -> return "24"
//               5 -> return "26"
//          }
//          return "Counter not found"
//
//     }
//     fun getAnswer4():String?{
//          when (uiState.value.counter){
//               1 -> return "31"
//               2 -> return "32"
//               3 -> return "34"
//               4 -> return "36"
//               5 -> return "39"
//          }
//          return "Counter not found"
//
//     }
     fun getCorrectAns(): Int?{
          return uiState1.value.correctanswers!![uiState.value.counter-1]
     }

}