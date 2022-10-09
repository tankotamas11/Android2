class ItemController {
    val itemService =ItemService()
    fun quiz(qNum: Int){

        val list : List<Item> = itemService.selectRandomItems(qNum)
        for (i in 1..qNum){
            println(list[i].question)
            list[i].answers.forEach {println(it)  }
            val a = readln().toInt()
            if ( a == list[i].correct){
                println("Correct answer")
            }
            else{
                println("Sorry , correct answer is : ${list[i].answers[list[i].correct]} ")
            }
        }

    }
}