import java.io.File
import kotlin.random.Random

class ItemRepository() {
    val items : MutableList<Item> = mutableListOf<Item>()

    init {
        val lines= File("kerdesek.txt").readLines()
        var i=0
        while(i<lines.size){
            val ansNum=lines[i++].toInt()
            val question : String=lines[i++]
            val correct : Int = lines[i++].toInt()

            val answers= mutableListOf<String>()
           // var s :Int = ansNum.toInt()+ i -1
            repeat(ansNum){answers.add(lines[i++])}
//            for (t in i .. s){
//                answers[t-i]=lines[t]
//            }
//            i=s+1


        val item=Item(question, answers, correct )
        save(item)
        }
    }
    fun randomItem():Item{
        val randomIndex = Random.nextInt(size())
        return items[randomIndex]
    }
    fun size(): Int = items.size

    fun save(i:Item){
        items.add(i)
    }
}