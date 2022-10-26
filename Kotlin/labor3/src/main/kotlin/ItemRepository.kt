import java.io.File
import java.util.*
import java.util.concurrent.ThreadLocalRandom

class ItemRepository {

    private val items = mutableListOf<Item>()

    init {
        val scanner = Scanner(File("Quiz.txt"))
        while (scanner.hasNextLine()){
            var line = scanner.nextLine()
            if (line.isEmpty()) {
                continue
            }
            if (line.toInt() > 0){
                val nrOfAnswers = line.toInt()
                val answersList = mutableListOf<String>()
                var counter = 0
                while (counter < nrOfAnswers){
                    line = scanner.nextLine()
                    answersList.add(line)
                    counter++
                }
                val question = scanner.nextLine()
                val answer = scanner.nextLine().toInt()
                save(Item(question,answersList, answer))
            }
        }
    }

    fun randomItem() : Item{
        val x = ThreadLocalRandom.current().nextInt(0, 9 + 1  )
        return items[x]
    }

    fun save(newItem:Item) {
        items.add(newItem)
    }

    fun size() : Int{
        return this.items.size
    }

}