import interfaces.IDictionary
import models.ListDictionary
import java.time.LocalDate
import kotlin.math.roundToInt


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
    println(listOf("elso", "ketto","harmincketto", "i").Longest())

    feladat3()
}

fun String.monogram() = this.split(" ").map{it.first().uppercase()}.joinToString("")

fun List<String>.joinBySeparator(separator : String) = this.joinToString(separator)
fun List<String>.Longest() :String{
    var h=0
    var segedi=""
    for (i in this){
        if(i.length> h){
            h=i.length
            segedi=i
        }
    }
    return segedi

}
fun Date.isLeapYear() : Boolean {
    var leapYear = false

    if (this.year % 4 == 0) {
        leapYear = if (this.year % 100 == 0) {
            this.year % 400 == 0
        } else
            true
    }
    return leapYear
}


fun Date.validateDate() : Boolean {
    var isValid = false
    if (this.year > 0) {
        if (this.month in 1..12) {
            if (this.day in 1..31) {
                isValid = true
            }
        }
    }
    return isValid
}

fun createRandomIntBetween(start: Int, end: Int): Int {
    return start + (Math.random() * (end - start)).roundToInt()
}

fun createRandomDate(start : Int, end : Int) : Date {
    val day = createRandomIntBetween(1, 28);
    val month = createRandomIntBetween(1, 12);
    val year = createRandomIntBetween(start, end);
    return Date(year, month, day)
}

fun printRandomDateList(list: List<Date>) {
    list.forEach { println(it) }
}

fun feladat3() {
    val date = Date()
    val current=LocalDate.now()
    println(current)
    println("Is leap year: " + current.isLeapYear())

    var validDates = 0
    val randomDatesList: MutableList<Date> = ArrayList()

    while (validDates <= 10) {
        val randomDates = createRandomDate(1900, 2000)
        if (randomDates.validateDate()) {
            validDates++
            randomDatesList.add(randomDates)
        } else {
            println(randomDates)
        }
    }


    printRandomDateList(randomDatesList)
    println("Sorted list:")
    randomDatesList.sort()
    printRandomDateList(randomDatesList)


    println("Reversed list:")
    randomDatesList.reverse()
    printRandomDateList(randomDatesList)


    val date1 = Date(1990, 12, 12)
    val date2 = Date(1990, 11, 10)
    print(date1 == date2)
}