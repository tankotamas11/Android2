
class ItemService {
    val itemRepository = ItemRepository()


    fun selectRandomItems(num: Int) : List<Item>{
        val items = mutableListOf<Item>()
        var t=0
        println(itemRepository.items)
        if(num>itemRepository.items.size){ return itemRepository.items}
        else {
            while (t < num) {
                val item2 = itemRepository.randomItem()
                if (items.size==0){items.add(item2)
                    t++}
                else {
                    for (s in items) {
                        if (!item2.question.equals(s)) {
                            println("hell1")
                            items.add(item2)
                            t++
                        }
                    }
                }

            }

            return items
        }
    }
}