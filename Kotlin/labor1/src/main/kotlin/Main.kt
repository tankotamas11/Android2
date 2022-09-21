import java.util.*

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
    println()
    println(encode("alma"));
    println(decode(encode("alma")));
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


    // encode a string using Base64 encoder
    val encoder: Base64.Encoder = Base64.getEncoder()
    val encoded: String = encoder.encodeToString(string.toByteArray())
    return (encoded)
}

 fun decode(string : String): String{   // decode the encoded data
    val decoder: Base64.Decoder = Base64.getDecoder()
    val decoded = String(decoder.decode(string))
    return (decoded)
}