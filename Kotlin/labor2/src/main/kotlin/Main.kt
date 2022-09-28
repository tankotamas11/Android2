import interfaces.IDictionary
import models.ListDictionary



fun main(){
//    val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.ARRAY_LIST)
//
//    println("Number of words: ${dict.size()}")
//    var word: String?
//    while(true){
//        print("What to find? ")
//        word = readLine()
//        if( word.equals("quit")){
//            break
//        }
//        println("Result: ${word?.let { dict.find(it) }}")
//    }
    println("Tanko Tamas".monogram())
    println(listOf("elso", "ketto").joinBySeparator("-"))
}

fun String.monogram() = this.split(" ").map{it.first().uppercase()}.joinToString("")

fun List<String>.joinBySeparator(separator : String) :String{
    return this.joinToString(separator)
}