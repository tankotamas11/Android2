import java.util.*

import kotlin.random.Random

fun main(args: Array<String>) {
    println("Hello World!")
    val szam = 2
    val szam2= 3
    println("$szam + $szam2 = ${szam+szam2}")

    val daysOfWeek= listOf("Monday", "Tuesday","Wednesday ", "Thursday", "Friday","Saturday", "Sunday")
    for (day in daysOfWeek){
        println(day)
    }

    println("T:")
    for (day in daysOfWeek){
       if (day[0] == 'T'){
           println(day)
       }
    }
    println("e:")
    for (day in daysOfWeek){

        if (day.contains( 'e')) {
            println(day)
        }

    }
    println("6:")
    for (day in daysOfWeek){

        if (day.length == 6) {
            println(day)
        }

    }

    println("Primszamok:")
    /*for (i in 1..100){

        if (Prime(i)){
            print("$i ");
        }
    }*/
        (2..100).filter{ Prime(it)}.forEach { print("$it ") }
    println("\nFeladat4:")
    println(encode("alma"));
    println(decode(encode("alma")));

    println("Feladat5:")
    fel5()
    println("\nFeladat 6:")
//6 feladat
    (2..5).map { it * 2 }.forEach { print("$it ") }
    println()
    daysOfWeek.map{it.uppercase()}.forEach { print("$it ") }
    println()
    daysOfWeek.map{it[0].lowercase()}.forEach { print("$it ") }
    println()
    daysOfWeek.map{"$it -> ${it.length}"}.forEach { print("$it ") }
    println()
    //51 karakter van, 7 kell osztani ami 7.285
    println("Average length of days :${daysOfWeek.map{it.length}.average()}")
    println("Feladat7:")
    val mutableList = mutableListOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
    mutableList.removeAll{ it.contains("n") }
    println(mutableList)
    mutableList.withIndex().forEach { println("Item at ${it.index} is ${it.value}") }

    mutableList.sort()
    println(mutableList)

    println("Feladat 8 :")
    val list= IntArray(10) {Random.nextInt(100)}.asList()
    list.forEach { print("$it ") }
    println()

    println("The array sorted in ascending order ${list.sorted()}")
    println("The array contains any even number: ${list.any {it % 2 == 0}}")
    println("All the numbers are even: ${list.all {it % 2 == 0}}")
    println("Average:${list.average()}")
}
fun fel5(){
    (2..11).filter{x-> x%2 ==0}.forEach { print("$it ") }
}
fun Prime(number : Int): Boolean{
    var a=0;
    for (i in 1..number){
        if (number % i == 0){
            a++;
        }
    }
    if(a==2){
        return true;
    }
    else{
        return false;
    }
}


fun encode(string : String) : String {



    val encoder: Base64.Encoder = Base64.getEncoder()
    val encoded: String = encoder.encodeToString(string.toByteArray())
    return (encoded)
}

 fun decode(string : String): String{
    val decoder: Base64.Decoder = Base64.getDecoder()
    val decoded = String(decoder.decode(string))
    return (decoded)
}